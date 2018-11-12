package com.bargains.service;

import com.bargains.entity.ProductEntity;
import com.bargains.service.cache.ProductCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

public class ProductCacheServiceImpl implements ProductCacheService {

    @Autowired
    private ProductService productService;

    @Cacheable(value = "MS_Cache", key = "'productdetail:' + #productId")
    public ProductEntity queryProductById(int productId) {
        System.out.println("come into queryProductById");
        return productService.queryProductById(productId);
    }

}
