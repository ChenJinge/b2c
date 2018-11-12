package com.bargains.service.cache;

import com.bargains.entity.BargainsEntity;


public interface BargainsCacheService {

    BargainsEntity queryProductById(int id);
}
