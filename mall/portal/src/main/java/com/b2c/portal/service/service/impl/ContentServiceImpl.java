package com.b2c.portal.service.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.HttpClientUtil;
import com.b2c.common.utils.JsonUtils;
import com.b2c.pojo.Content;
import com.b2c.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_INDEX_AD_URL}")
    private String REST_INDEX_AD_URL;

    @Override
    public String getContentList() {
        //调用服务层的服务
        String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
        //把字符串转换成ResponseResult
        try {
            ResponseResult b2cResult = ResponseResult.formatToList(result, Content.class);
            //取内容列表
            List<Content> list = (List<Content>) b2cResult.getData();
            List<Map> resultList = new ArrayList<>();
            //创建一个jsp页码要求的pojo列表
            for (Content tbContent : list) {
                Map map = new HashMap<>();
                map.put("src", tbContent.getPic());
                map.put("height", 240);
                map.put("width", 670);
                map.put("srcB", tbContent.getPic2());
                map.put("widthB", 550);
                map.put("heightB", 240);
                map.put("href", tbContent.getUrl());
                map.put("alt", tbContent.getSubTitle());
                resultList.add(map);
            }
            return JsonUtils.objectToJson(resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
