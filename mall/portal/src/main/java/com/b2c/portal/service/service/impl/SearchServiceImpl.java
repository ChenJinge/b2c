package com.b2c.portal.service.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.HttpClientUtil;
import com.b2c.portal.pojo.SearchResult;
import com.b2c.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;

    @Override
    public SearchResult search(String queryString, int page) {
        // 调用b2c-search的服务
        //查询参数
        Map<String, String> param = new HashMap<>();
        param.put("q", queryString);
        param.put("page", page + "");
        try {
            //调用服务
            String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
            //把字符串转换成java对象
            ResponseResult b2cResult = ResponseResult.formatToPojo(json, SearchResult.class);
            if (b2cResult.getStatus() == 200) {
                SearchResult result = (SearchResult) b2cResult.getData();
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
