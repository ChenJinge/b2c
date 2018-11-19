package com.bargains.service.impl;

import com.bargains.entity.OrderEntity;
import com.bargains.service.OrderService;
import com.bargains.util.DateUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class OrderInfoService implements MessageListener {

    @Autowired
    OrderService orderService;

    public void onMessage(Message message) {
        try {
            byte[] messageByte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messageByte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> dataMap = (Map<String, String>) obj.readObject();

            String createTime = dataMap.get("createTime");
            String merchantId = dataMap.get("merchantId");
            String payAmount = dataMap.get("payAmount");
            String receivingAdress = dataMap.get("receivingAdress");
            String receivingPhone = dataMap.get("receivingPhone");
            String stock = dataMap.get("stock");
            String receivingName = dataMap.get("receivingName");
            String tradeSerialNumber = dataMap.get("tradeSerialNumber");
            String payStatus = dataMap.get("payStatus");
            String productId = dataMap.get("productId");
            String userId = dataMap.get("userId");

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setUserId(Integer.valueOf(userId));
            orderEntity.setProductId(Integer.valueOf(productId));
            orderEntity.setCreateTime(DateUtils.transferdate(createTime, "yyyy-MM-dd HH:mm:ss"));
            orderEntity.setTradeSerialNumber(tradeSerialNumber);
            orderEntity.setMerchantId(Integer.valueOf(merchantId));
            orderEntity.setPayAmount(Integer.valueOf(payAmount));
            orderEntity.setPayStatus(Integer.valueOf(payStatus));
            orderEntity.setReceivingAddress(receivingAdress);
            orderEntity.setReceivingName(receivingName);
            orderEntity.setReceivingPhone(receivingPhone);
            orderEntity.setProductQuantity(Integer.valueOf(stock));
            orderService.insertOrder(orderEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("the order information is : " + message.toString());
    }
}
