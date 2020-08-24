package com.smith.service.impl;

import com.smith.dao.UserInfoDao;
import com.smith.entity.UserInfo;
import com.smith.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public UserInfo queryByName(String name) {
        return userInfoDao.queryByName(name);
    }
}
