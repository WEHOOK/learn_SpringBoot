package com.smith.springboot_jpa.service;


import com.smith.springboot_jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
public interface UserService {
    UserEntity add(UserEntity user);

    UserEntity update(UserEntity user);

    String delete(int id);

    Optional<UserEntity> findUserById(int id);

    List<UserEntity> findUserList();
}
