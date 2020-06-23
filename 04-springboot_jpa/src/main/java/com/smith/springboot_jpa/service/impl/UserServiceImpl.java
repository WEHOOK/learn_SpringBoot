package com.smith.springboot_jpa.service.impl;


import com.smith.springboot_jpa.dao.UserDao;
import com.smith.springboot_jpa.entity.UserEntity;
import com.smith.springboot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public UserEntity add(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public String delete(int id) {
        String resultString = "success";
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            resultString = "fail";
        }

        return resultString;
    }

    @Override
    public Optional<UserEntity> findUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<UserEntity> findUserList() {
        return userDao.findAll();
    }
}
