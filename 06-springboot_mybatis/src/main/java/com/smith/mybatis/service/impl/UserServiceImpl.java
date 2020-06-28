package com.smith.mybatis.service.impl;

import com.smith.mybatis.dao.UserMapper;
import com.smith.mybatis.entity.UserEntity;
import com.smith.mybatis.service.UserService;
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
    private UserMapper userDao;

    @Override
    public int add(UserEntity user) {
        return userDao.add(user.getName(),user.getTel());
    }

    @Override
    public int update(UserEntity user) {
        return userDao.update(user.getName(),user.getTel(),user.getId());
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
