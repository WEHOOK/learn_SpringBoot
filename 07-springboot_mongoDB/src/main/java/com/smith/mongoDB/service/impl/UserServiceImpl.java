package com.smith.mongoDB.service.impl;

import com.smith.mongoDB.dao.UserDao;
import com.smith.mongoDB.entity.UserEntity;
import com.smith.mongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author gaoyu
 * @date 2020-07-06
 * @description
 */
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity addUser(UserEntity user) {
        return userDao.insert(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<UserEntity> findUserById(String id) {
        return  userDao.findById(id);
    }

    @Override
    public List<UserEntity> findUserByName(String name) {
        return userDao.findByName(name);
    }
}
