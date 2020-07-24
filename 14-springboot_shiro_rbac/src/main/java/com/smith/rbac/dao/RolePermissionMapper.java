package com.smith.rbac.dao;

import com.smith.rbac.entity.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}