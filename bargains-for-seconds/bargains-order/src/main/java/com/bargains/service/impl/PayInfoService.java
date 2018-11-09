package com.bargains.service.impl;

import com.bargains.service.OrderService;
import com.bargains.util.DateUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class PayInfoService implements MessageListener {

    @Autowired
    OrderService orderService;

    public void onMessage(Message message) {

        try {
            byte[] messsagebyte = message.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(messsagebyte);
            ObjectInputStream obj;
            obj = new ObjectInputStream(in);
            Map<String, String> datamap = (Map<String, String>) obj.readObject();
            String tradeserialnumber = datamap.get("tradeserialnumber");
            String paystatus = datamap.get("paystatus");
            String paytimestring = datamap.get("paytimestring");
            String paytype = datamap.get("paytype");

            orderService.updateOrderByTrNumber(Integer.valueOf(paystatus), tradeserialnumber, Integer.valueOf(paytype), DateUtils.transferdate(paytimestring, "yyyy-MM-dd HH:mm:ss"));

            System.out.println("��Ϣ������ = " + message.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
