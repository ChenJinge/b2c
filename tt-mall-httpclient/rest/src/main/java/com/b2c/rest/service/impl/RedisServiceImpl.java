package com.b2c.rest.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.ExceptionUtil;
import com.b2c.rest.dao.JedisClient;
import com.b2c.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private JedisClient jedisClient;

    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Override
    public ResponseResult syncContent(long contentCid) {
        try {
            jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return ResponseResult.ok();
    }

}
