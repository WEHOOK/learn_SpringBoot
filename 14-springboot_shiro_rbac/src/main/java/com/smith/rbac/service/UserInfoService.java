package com.smith.rbac.service;

import com.smith.rbac.entity.SysUser;

import java.util.List;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
public interface UserInfoService {
    SysUser queryByName(String name);

    List<SysUser> getUserList();
}
