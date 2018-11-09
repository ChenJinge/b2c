package com.bargains.dao;

import com.bargains.enity.UserEntity;
import com.bargains.vo.user.UserVo;

import java.util.List;

public interface UserDao {
    void insertUser(UserEntity userEntity);

    UserEntity queryUserById(int id);

    void updateUser(UserEntity userEntity);

    void deleteUserById(int id);

    List<UserEntity> queryUserByVo(UserVo userVo);

    UserEntity queryUserByAccount(String account);
}
