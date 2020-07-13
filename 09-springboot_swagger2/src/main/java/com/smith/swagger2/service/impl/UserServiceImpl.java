package com.smith.swagger2.service.impl;


import com.smith.swagger2.dao.UserMapper;
import com.smith.swagger2.entity.UserEntity;
import com.smith.swagger2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 开启事务
     * @param money
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void  updateTransactional(String money) {

        Integer m = Integer.valueOf(money);
        userDao.updateTran1(m);
        int i = 1 /0;
        userDao.updateTran2(m);
    }
}
