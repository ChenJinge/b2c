package com.bargains.dao;

import com.bargains.enity.OrderEntity;
import com.bargains.vo.order.OrderVo;

import java.util.List;

public interface OrderDao {
    void insertOrder(OrderEntity orderEntity);

    List<OrderEntity> queryOrderByUserId(int userId);

    void updateOrderPayStatusById(OrderVo orderVo);

    void updateOrderByTrNumber(OrderVo orderVo);

    List<OrderEntity> queryOrderByMerchantId(int merchantId);
}
