package com.smith.session.service.impl;


import com.smith.session.dao.SysUserMapper;
import com.smith.session.entity.SysUser;
import com.smith.session.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public SysUser queryByName(String name) {
        return sysUserMapper.selectByUserName(name);
    }

    @Override
    public List<SysUser> getUserList() {
        return sysUserMapper.getUserList();
    }
}
