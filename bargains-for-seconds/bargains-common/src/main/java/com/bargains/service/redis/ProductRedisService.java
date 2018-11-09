package com.bargains.service.redis;

import com.bargains.enity.ProductEntity;


public interface ProductRedisService {

    ProductEntity queryProductById(int id);

}
