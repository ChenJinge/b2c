package com.bargains.service.redis;

import com.bargains.entity.OrderEntity;
import com.bargains.vo.order.CustomOrder;

import java.util.List;
import java.util.Map;

public interface OrderRedisService {
    Map<String, Object> snatchBargains(int userId, int productId, CustomOrder order);

    boolean payOrder(int payType, int userId, int productId, int merchantId, String tradeSerialNumber, int payAmount);

    List<OrderEntity> queryOrderByUserId(int userId);
}
