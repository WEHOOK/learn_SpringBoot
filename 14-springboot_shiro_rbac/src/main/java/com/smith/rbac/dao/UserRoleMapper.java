package com.smith.rbac.dao;

import com.smith.rbac.entity.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}