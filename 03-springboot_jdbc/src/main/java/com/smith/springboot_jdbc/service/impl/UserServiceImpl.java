package com.smith.springboot_jdbc.service.impl;

import com.smith.springboot_jdbc.dao.UserDao;
import com.smith.springboot_jdbc.entity.UserEntity;
import com.smith.springboot_jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int add(UserEntity user) {
        return userDao.add(user);
    }

    @Override
    public int update(UserEntity user) {
        return userDao.update(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public UserEntity findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<UserEntity> findUserList() {
        return userDao.findUserList();
    }
}
