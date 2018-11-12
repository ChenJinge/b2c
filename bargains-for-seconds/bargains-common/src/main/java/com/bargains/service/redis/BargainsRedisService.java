package com.bargains.service.redis;

import com.bargains.entity.BargainsEntity;

public interface BargainsRedisService {

    BargainsEntity queryBargainsById(int id);

}
