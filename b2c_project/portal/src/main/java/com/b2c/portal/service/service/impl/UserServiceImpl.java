package com.b2c.portal.service.service.impl;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.common.utils.HttpClientUtil;
import com.b2c.pojo.User;
import com.b2c.portal.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Value("${SSO_BASE_URL}")
    public String SSO_BASE_URL;
    @Value("${SSO_DOMAIN_BASE_USRL}")
    public String SSO_DOMAIN_BASE_USRL;
    @Value("${SSO_USER_TOKEN}")
    private String SSO_USER_TOKEN;
    @Value("${SSO_PAGE_LOGIN}")
    public String SSO_PAGE_LOGIN;


    @Override
    public User getUserByToken(String token) {
        try {
            //调用sso系统的服务，根据token取用户信息
            String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN + token);
            //把json转换成TaotaoREsult
            ResponseResult result = ResponseResult.formatToPojo(json, User.class);
            if (result.getStatus() == 200) {
                User user = (User) result.getData();
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
