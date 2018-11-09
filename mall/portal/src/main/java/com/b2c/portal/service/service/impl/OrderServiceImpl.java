package com.b2c.portal.service.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.HttpClientUtil;
import com.b2c.common.utils.JsonUtils;
import com.b2c.portal.pojo.ExOrder;
import com.b2c.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${ORDER_BASE_URL}")
    private String ORDER_BASE_URL;
    @Value("${ORDER_CREATE_URL}")
    private String ORDER_CREATE_URL;


    @Override
    public String createOrder(ExOrder order) {
        //调用创建订单服务之前补全用户信息。
        //从cookie中后取TT_TOKEN的内容，根据token调用sso系统的服务根据token换取用户信息。

        //调用b2c-order的服务提交订单。
        String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
        //把json转换成b2cResult
        ResponseResult b2cResult = ResponseResult.format(json);
        if (b2cResult.getStatus() == 200) {
            Object orderId = b2cResult.getData();
            return orderId.toString();
        }
        return "";
    }

}