package com.bargains.redis;

import com.bargains.enity.BargainsEntity;
import com.bargains.service.cache.BargainsCacheService;
import com.bargains.service.redis.BargainsRedisService;
import org.springframework.beans.factory.annotation.Autowired;


public class BargainsRedisServiceImpl implements BargainsRedisService {

    @Autowired
    private BargainsCacheService bargainsCacheService;

    @Autowired
    private RedisUtil redisUtil;

    public BargainsEntity queryBargainsById(int id) {
        BargainsEntity bargainsEntity = null;
        Object value = redisUtil.get("product:" + id);
        if (value == null) {
            bargainsEntity = bargainsCacheService.queryProductById(id);
            redisUtil.set("product:" + id, bargainsEntity);
        } else {
            System.out.println("come into  redis --  queryProductById");
            bargainsEntity = (BargainsEntity) value;
        }
        return bargainsEntity;
    }


}
