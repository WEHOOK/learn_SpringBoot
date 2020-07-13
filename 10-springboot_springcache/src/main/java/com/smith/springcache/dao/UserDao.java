package com.smith.springcache.dao;

import com.smith.springcache.entity.UserEntity;

/**
 * @author gaoyu
 * @date 2020-07-13
 * @description
 */
public interface UserDao {

    UserEntity getUserList(Integer id);
}
