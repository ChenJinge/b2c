package com.bargains.service.redis;

import com.bargains.enity.BargainsEntity;

public interface BargainsRedisService {

    BargainsEntity queryBargainsById(int id);

}
