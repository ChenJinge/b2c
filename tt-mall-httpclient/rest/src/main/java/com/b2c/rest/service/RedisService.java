package com.b2c.rest.service;

import com.b2c.common.pojo.ResponseResult;

public interface RedisService {

	ResponseResult syncContent(long contentCid);
}
