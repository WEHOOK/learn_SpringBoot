package com.smith.mongoDB.service;

import com.smith.mongoDB.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author gaoyu
 * @date 2020-07-06
 * @description
 */
public interface UserService {

    public UserEntity addUser(UserEntity user);

    public UserEntity updateUser(UserEntity user);

    public List<UserEntity> findAll();

    public Optional<UserEntity> findUserById(String id);

    public List<UserEntity> findUserByName(String name);


}
