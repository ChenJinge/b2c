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
            byte[] messsagebyte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messsagebyte);
            ObjectInputStream obj = new ObjectInputStream(in);
            Map<String, String> datamap = (Map<String, String>) obj.readObject();

            String createtime = datamap.get("createtime");
            String merchantid = datamap.get("merchantid");
            String payamount = datamap.get("payamount");
            String receivingadress = datamap.get("receivingadress");
            String receivingphone = datamap.get("receivingphone");
            String stockcountnum = datamap.get("stockcountnum");
            String receivingname = datamap.get("receivingname");
            String tradeserialnumber = datamap.get("tradeserialnumber");
            String paystatus = datamap.get("paystatus");
            String productid = datamap.get("productid");
            String userid = datamap.get("userid");

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setUserId(Integer.valueOf(userid));
            orderEntity.setProductId(Integer.valueOf(productid));
            orderEntity.setCreateTime(DateUtils.transferdate(createtime, "yyyy-MM-dd HH:mm:ss"));
            orderEntity.setTradeSerialNumber(tradeserialnumber);
            orderEntity.setMerchantId(Integer.valueOf(merchantid));
            orderEntity.setPayAmount(Integer.valueOf(payamount));
            orderEntity.setPayStatus(Integer.valueOf(paystatus));
            orderEntity.setReceivingAddress(receivingadress);
            orderEntity.setReceivingName(receivingname);
            orderEntity.setReceivingPhone(receivingphone);
            orderEntity.setProductQuantity(1);
            orderService.insertOrder(orderEntity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("��Ϣ������ = " + message.toString());
    }
}
