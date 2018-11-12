package com.b2c.portal.service;

import com.b2c.pojo.User;

public interface UserService {

    User getUserByToken(String token);
}
