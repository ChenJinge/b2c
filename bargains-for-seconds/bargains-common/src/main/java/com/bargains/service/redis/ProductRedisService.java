package com.bargains.service.redis;

import com.bargains.entity.ProductEntity;


public interface ProductRedisService {

    ProductEntity queryProductById(int id);

}
