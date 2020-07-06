package com.smith.mybatis.service;


import com.smith.mybatis.entity.UserEntity;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
public interface UserService {
    int add(UserEntity user);

    int update(UserEntity user);

    int delete(int id);

    UserEntity findUserById(int id);

    List<UserEntity> findUserList();

    void updateTransactional(String money);
}
