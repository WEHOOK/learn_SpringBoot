package com.smith.service;


import com.smith.entity.UserEntity;
import org.beetl.sql.core.db.KeyHolder;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
public interface UserService {
    KeyHolder add(UserEntity user);

    Integer update(UserEntity user);

    Integer delete(int id);

    UserEntity findUserById(int id);

    UserEntity findUserByName(String name);

    List<UserEntity> findUserList();
}
