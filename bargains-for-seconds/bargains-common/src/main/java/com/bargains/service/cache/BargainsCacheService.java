package com.bargains.service.cache;

import com.bargains.enity.BargainsEntity;


public interface BargainsCacheService {

    BargainsEntity queryProductById(int id);
}
