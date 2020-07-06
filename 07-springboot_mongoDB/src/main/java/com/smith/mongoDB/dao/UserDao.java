package com.smith.mongoDB.dao;

import com.smith.mongoDB.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-07-06
 * @description
 */
public interface UserDao extends MongoRepository<UserEntity,String> {
    public List<UserEntity> findByName(String name);

}
