package com.bargains.service.redis;

import com.bargains.enity.OrderEntity;
import com.bargains.vo.order.CustomOrder;

import java.util.List;
import java.util.Map;

public interface OrderRedisService {
    public Map<String, Object> seckill(int userid, int productid, CustomOrder msorder);

    public boolean payorder(int paytype, int userid, int productid, int merchantid, String tradeserialnumber, int payamount);

    public List<OrderEntity> queryorderbyuserid(int userid);
}
