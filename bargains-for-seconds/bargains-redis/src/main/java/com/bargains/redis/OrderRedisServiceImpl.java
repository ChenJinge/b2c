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

        String createtimestring = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        String merchantid = Order.getMerchantId() + "";
        String payamount = Order.getPayAmount() + "";
        String receivingadress = Order.getReceivingAddress();
        String receivingname = Order.getReceivingName();
        String receivingphone = Order.getReceivingPhone();
        String stockcountnum = Order.getStock() + "";
        String tradeserialnumber = createtimestring + UUID.randomUUID();
        String paystatus = "1";

        value += paystatus + "==" + tradeserialnumber + "==" + createtimestring + "==" + merchantid + "==" + payamount + "==" + receivingadress + "==" + receivingname + "==" + receivingphone + "==" + stockcountnum;
        redisUtil.set(key, value);

        Map<String, String> datamap = new HashMap<String, String>();

        datamap.put("createtime", createtimestring);
        datamap.put("merchantid", merchantid);
        datamap.put("payamount", payamount);
        datamap.put("receivingadress", receivingadress);
        datamap.put("receivingname", receivingname);
        datamap.put("receivingphone", receivingphone);
        datamap.put("stockcountnum", stockcountnum);
        datamap.put("tradeserialnumber", tradeserialnumber);
        datamap.put("paystatus", paystatus);
        datamap.put("productid", productId + "");
        datamap.put("userid", userId + "");

        amqpTemplate.convertAndSend("ms_exchange", "orderinfomation", datamap);

        resultMap.put("success", true);
        resultMap.put("datamap", datamap);
        return resultMap;
    }

    public boolean payOrder(int payType, int userId, int productId, int merchantId, String tradeSerialNumber, int payAmount) {

        String key = "userId:" + userId + "==productId:" + productId;
        String value = (String) redisUtil.get(key);
        String[] splitvalues = value.split("==");
        splitvalues[0] = "2";
        value = "";

        for (String temp : splitvalues) {
            value += temp + "==";
        }

        boolean issuccess = redisUtil.set(key, value);
        Map<String, String> datamap = new HashMap<String, String>();
        datamap.put("tradeserialnumber", tradeSerialNumber);
        datamap.put("paystatus", "2");
        String paytimestring = DateUtils.transferdate(new Date(), "yyyy-MM-dd HH:mm:ss");
        datamap.put("paytimestring", paytimestring);
        datamap.put("paytype", payType + "");
        amqpTemplate.convertAndSend("ms_exchange", "payinfomation", datamap);

        return issuccess;
    }

    public List<OrderEntity> queryOrderByUserId(int userid) {
        List<OrderEntity> listmsorder = new ArrayList<OrderEntity>();
        Set<String> keys = redisUtil.getkeys("user id:" + userid);

        for (String key : keys) {
            String[] prusers = key.split("==");

            if (prusers.length <= 1) {
                continue;
            }

            String productid = prusers[1].split(":")[1];
            String useridstring = prusers[0].split(":")[1];
            String value = (String) redisUtil.get(key);
            String[] valuearray = value.split("==");
            String paystatus = valuearray[0];
            String tradeserialnumber = valuearray[1];
            String createtimestring = valuearray[2];
            String merchantid = valuearray[3];
            String payamount = valuearray[4];
            String receivingadress = valuearray[5];
            String receivingname = valuearray[6];
            String receivingphone = valuearray[7];
            String stockcountnum = valuearray[8];

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setCreateTime(DateUtils.transferdate(createtimestring, "yyyy-MM-dd HH:mm:ss"));
            orderEntity.setPayAmount(Integer.valueOf(payamount));
            orderEntity.setMerchantId(Integer.valueOf(merchantid));
            orderEntity.setReceivingAddress(receivingadress);
            orderEntity.setReceivingName(receivingname);
            orderEntity.setProductId(Integer.valueOf(productid));
            orderEntity.setReceivingPhone(receivingphone);
            orderEntity.setTradeSerialNumber(tradeserialnumber);
            orderEntity.setUserId(userid);
            orderEntity.setProductQuantity(1);
            orderEntity.setPayStatus(Integer.valueOf(paystatus));
            listmsorder.add(orderEntity);
        }
        return listmsorder;
    }

}
