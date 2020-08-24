package com.smith.service;


import com.smith.entity.UserInfo;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
public interface UserInfoService {
    UserInfo queryByName(String name);
}
