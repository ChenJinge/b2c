package com.bargains.service.cache;

import com.bargains.enity.ProductEntity;


public interface ProductCacheService {

    ProductEntity queryProductById(int productid);
}
