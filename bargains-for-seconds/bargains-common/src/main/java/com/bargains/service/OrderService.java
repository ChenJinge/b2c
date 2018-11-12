package com.bargains.service;

import com.bargains.entity.OrderEntity;

import java.util.Date;
import java.util.List;

public interface OrderService {

    void insertOrder(OrderEntity orderEntity);

    List<OrderEntity> queryOrderByMerchantId(int merchantId);

    void updateOrderPayStatusById(int payStatus, int id, int payType);

    void updateOrderByTrNumber(int payStatus, String tradeSerialNumber, int payType, Date payTime);
}
