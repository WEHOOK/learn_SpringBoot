package com.smith.springcache.dao.impl;

import com.smith.springcache.dao.UserDao;
import com.smith.springcache.entity.UserEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author gaoyu
 * @date 2020-07-13
 * @description
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    @Cacheable(value = "user")
    public UserEntity getUserList(Integer id) {
        setSlowQuery();
        return new UserEntity(id, "2", "3");
    }

    private void setSlowQuery() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
