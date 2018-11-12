package com.b2c.rest.service.impl;

import com.b2c.common.utils.JsonUtils;
import com.b2c.mapper.ContentMapper;
import com.b2c.pojo.Content;
import com.b2c.pojo.ContentExample;
import com.b2c.pojo.ContentExample.Criteria;
import com.b2c.rest.dao.JedisClient;
import com.b2c.rest.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;


    @Override
    public List<Content> getContentList(long contentCid) {
        //从缓存中取内容
        try {
            String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid + "");
            if (!StringUtils.isBlank(result)) {
                //把字符串转换成list
                List<Content> resultList = JsonUtils.jsonToList(result, Content.class);
                return resultList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //根据内容分类id查询内容列表
        ContentExample example = new ContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);
        //执行查询
        List<Content> list = contentMapper.selectByExample(example);

        //向缓存中添加内容
        try {
            //把list转换成字符串
            String cacheString = JsonUtils.objectToJson(list);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "", cacheString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
