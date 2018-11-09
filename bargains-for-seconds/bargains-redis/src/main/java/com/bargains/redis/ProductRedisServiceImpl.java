package com.bargains.redis;

import com.bargains.enity.ProductEntity;
import com.bargains.service.cache.ProductCacheService;
import com.bargains.service.redis.ProductRedisService;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductRedisServiceImpl implements ProductRedisService {

    @Autowired
    private ProductCacheService productCacheService;

    @Autowired
    private RedisUtil redisUtil;

    public ProductEntity queryProductById(int productId) {
        ProductEntity productEntity = null;
        Object result = redisUtil.get("detail:" + productId);
        if (result == null) {
            productEntity = productCacheService.queryProductById(productId);
            redisUtil.set("detail:" + productId, productEntity);
        } else {
            System.out.println("come into redis -- queryProductById");
            productEntity = (ProductEntity) result;
        }
        return productEntity;
    }

}
