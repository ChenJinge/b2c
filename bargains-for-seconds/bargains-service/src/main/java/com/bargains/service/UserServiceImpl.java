package com.bargains.service;

import com.bargains.dao.UserDao;
import com.bargains.entity.UserEntity;
import com.bargains.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }

    public UserEntity queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    public void updateUser(UserEntity userEntity) {
        userDao.updateUser(userEntity);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public List<UserEntity> queryUserByVo(UserVo userVo) {
        return userDao.queryUserByVo(userVo);
    }

    public UserEntity queryUserByAccount(String account) {
        return userDao.queryUserByAccount(account);
    }

}
