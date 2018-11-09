package com.bargains.service;

import com.bargains.enity.BargainsEntity;
import com.bargains.service.cache.BargainsCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


public class BargainsCacheServiceImpl implements BargainsCacheService {

    @Autowired
    private BargainsService bargainsService;

    @Cacheable(value = "MS_Cache", key = "'product:' + #id")
    public BargainsEntity queryProductById(int id) {
        System.out.println("come into queryProductById");

        return bargainsService.queryProductById(id);
    }


}
