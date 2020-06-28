package com.smith.service.impl;




import com.smith.dao.UserDao;
import com.smith.entity.UserEntity;
import com.smith.service.UserService;
import org.beetl.sql.core.db.KeyHolder;
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
    public KeyHolder add(UserEntity user) {
        return userDao.insertReturnKey(user);
    }

    @Override
    public Integer update(UserEntity user) {
        return userDao.updateById(user);
    }

    @Override
    public Integer delete(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public UserEntity findUserById(int id) {
        return userDao.unique(id);
    }

    @Override
    public UserEntity findUserByName(String name) {
        return userDao.selectUserByName(name);
    }


    @Override
    public List<UserEntity> findUserList() {
        return userDao.all();
    }
}
