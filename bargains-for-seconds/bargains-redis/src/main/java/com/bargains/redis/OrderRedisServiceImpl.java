package com.bargains.redis;

import com.bargains.entity.OrderEntity;
import com.bargains.service.redis.OrderRedisService;
import com.bargains.util.DateUtils;
import com.bargains.vo.order.CustomOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class OrderRedisServiceImpl implements OrderRedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public Map<String, Object> snatchBargains(int userId, int productId, CustomOrder Order) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        int stockCount = Order.getStock();

        if (redisUtil.getkeylistsize(productId + "") > stockCount) {
            resultMap.put("success", false);
        }

        redisUtil.pushlist(productId + "", userId + "");
        String key = "user id:" + userId + "==product id:" + productId;
        String value = "";

        String createTimeString = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        String merchantId = Order.getMerchantId() + "";
        String payAmount = Order.getPayAmount() + "";
        String receivingAddress = Order.getReceivingAddress();
        String receivingName = Order.getReceivingName();
        String receivingPhone = Order.getReceivingPhone();
        String stock = Order.getStock() + "";
        String tradeSerialNumber = createTimeString + UUID.randomUUID();
        String payStatus = "1";

        value += payStatus + "==" + tradeSerialNumber + "==" + createTimeString + "==" + merchantId + "==" + payAmount + "==" + receivingAddress + "==" + receivingName + "==" + receivingPhone + "==" + stock;
        redisUtil.set(key, value);

        Map<String, String> datamap = new HashMap<String, String>();

        datamap.put("createTime", createTimeString);
        datamap.put("merchantId", merchantId);
        datamap.put("payAmount", payAmount);
        datamap.put("receivingAdress", receivingAddress);
        datamap.put("receivingName", receivingName);
        datamap.put("receivingPhone", receivingPhone);
        datamap.put("stock", stock);
        datamap.put("tradeSerialNumber", tradeSerialNumber);
        datamap.put("payStatus", payStatus);
        datamap.put("productId", productId + "");
        datamap.put("userId", userId + "");

        amqpTemplate.convertAndSend("bargains_exchange", "orderinfomation", datamap);

        resultMap.put("success", true);
        resultMap.put("datamap", datamap);
        return resultMap;
    }

    public boolean payOrder(int payType, int userId, int productId, int merchantId, String tradeSerialNumber, int payAmount) {

        String key = "userId:" + userId + "==productId:" + productId;
        String value = (String) redisUtil.get(key);
        String[] splitValues = value.split("==");
        splitValues[0] = "2";
        value = "";

        for (String temp : splitValues) {
            value += temp + "==";
        }

        boolean isSuccess = redisUtil.set(key, value);
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("tradeSerialNumber", tradeSerialNumber);
        dataMap.put("payStatus", "2");
        String payTimeStr = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        dataMap.put("payTime", payTimeStr);
        dataMap.put("payType", payType + "");
        amqpTemplate.convertAndSend("bargains_exchange", "payinfomation", dataMap);

        return isSuccess;
    }

    public List<OrderEntity> queryOrderByUserId(int userid) {
        List<OrderEntity> orders = new ArrayList<OrderEntity>();
        Set<String> keys = redisUtil.getkeys("user id:" + userid);

        for (String key : keys) {
            String[] prusers = key.split("==");

            if (prusers.length <= 1) {
                continue;
            }

            String productId = prusers[1].split(":")[1];
            String value = (String) redisUtil.get(key);
            String[] valueArray = value.split("==");
            String payStatus = valueArray[0];
            String tradeSerialNumber = valueArray[1];
            String createTimeStr = valueArray[2];
            String merchantId = valueArray[3];
            String payAmount = valueArray[4];
            String receivingAdress = valueArray[5];
            String receivingName = valueArray[6];
            String receivingPhone = valueArray[7];
            String stock = valueArray[8];

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setCreateTime(DateUtils.transferdate(createTimeStr, "yyyy-MM-dd HH:mm:ss"));
            orderEntity.setPayAmount(Integer.valueOf(payAmount));
            orderEntity.setMerchantId(Integer.valueOf(merchantId));
            orderEntity.setReceivingAddress(receivingAdress);
            orderEntity.setReceivingName(receivingName);
            orderEntity.setProductId(Integer.valueOf(productId));
            orderEntity.setReceivingPhone(receivingPhone);
            orderEntity.setTradeSerialNumber(tradeSerialNumber);
            orderEntity.setUserId(userid);
            orderEntity.setProductQuantity(Integer.valueOf(stock));
            orderEntity.setPayStatus(Integer.valueOf(payStatus));
            orders.add(orderEntity);
        }
        return orders;
    }

}
