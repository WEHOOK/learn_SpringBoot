package com.smith.springboot_jpa.dao;


import com.smith.springboot_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {


}
