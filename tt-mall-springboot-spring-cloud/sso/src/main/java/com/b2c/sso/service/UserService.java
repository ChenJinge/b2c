package com.b2c.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.b2c.common.pojo.ResponseResult;
import com.b2c.pojo.User;

public interface UserService {

	ResponseResult checkData(String content, Integer type);
	ResponseResult createUser(User user);
	ResponseResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	ResponseResult getUserByToken(String token);
}
