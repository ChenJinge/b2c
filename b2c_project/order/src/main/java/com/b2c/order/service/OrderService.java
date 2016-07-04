package com.b2c.order.service;

import java.util.List;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.pojo.Order;
import com.b2c.pojo.OrderItem;
import com.b2c.pojo.OrderShipping;

public interface OrderService {

    ResponseResult createOrder(Order order, List<OrderItem> itemList, OrderShipping orderShipping);
}
