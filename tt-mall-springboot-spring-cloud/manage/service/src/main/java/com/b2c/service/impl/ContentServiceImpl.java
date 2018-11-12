package com.b2c.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.HttpClientUtil;
import com.b2c.mapper.ContentMapper;
import com.b2c.pojo.Content;
import com.b2c.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by chenjinge on 2016/7/4.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_CONTENT_SYNC_URL}")
    private String REST_CONTENT_SYNC_URL;


    @Override
    public ResponseResult insertContent(Content content) {

        //补全pojo内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);

        //添加缓存同步逻辑
        try {
            HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseResult.ok();
    }

}
