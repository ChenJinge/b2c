package com.bargains.service;

import com.bargains.entity.UserEntity;
import com.bargains.vo.user.UserVo;

import java.util.List;

public interface UserService {

    void insertUser(UserEntity userEntity);

    UserEntity queryUserById(int id);

    void updateUser(UserEntity userEntity);

    void deleteUserById(int id);

    List<UserEntity> queryUserByVo(UserVo userVo);

    UserEntity queryUserByAccount(String account);

}
