package com.bargains.service.cache;

import com.bargains.entity.ProductEntity;


public interface ProductCacheService {

    ProductEntity queryProductById(int productid);
}
