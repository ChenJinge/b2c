package com.bargains.service;

import com.bargains.dao.OrderDao;
import com.bargains.entity.OrderEntity;
import com.bargains.vo.order.CustomOrder;
import com.bargains.vo.order.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    public void insertOrder(OrderEntity orderEntity) {
        orderDao.insertOrder(orderEntity);
    }

    public List<OrderEntity> queryOrderByUserId(int userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    public List<OrderEntity> queryOrderByMerchantId(int merchantId) {
        return orderDao.queryOrderByMerchantId(merchantId);
    }

    public void updateOrderPayStatusById(int payStatus, int id, int payType) {
        OrderVo orderVo = new OrderVo();
        CustomOrder customOrder = new CustomOrder();

        customOrder.setPayStatus(payStatus);
        customOrder.setId(id);
        customOrder.setPayType(payType);
        orderVo.setCustomOrder(customOrder);

        orderDao.updateOrderPayStatusById(orderVo);
    }

    public void updateOrderByTrNumber(int payStatus, String tradeSerialNumber, int payType, Date payTime) {
        OrderVo orderVo = new OrderVo();
        CustomOrder customOrder = new CustomOrder();

        customOrder.setPayStatus(payStatus);
        customOrder.setTradeSerialNumber(tradeSerialNumber);
        customOrder.setPayType(payType);
        customOrder.setPayTime(payTime);
        orderVo.setCustomOrder(customOrder);

        orderDao.updateOrderByTrNumber(orderVo);
    }
}
