package com.smith.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author gaoyu
 * @date 2020-07-06
 * @description
 */
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public void setkey(String key,String value){
        ValueOperations<String,String> option = stringRedisTemplate.opsForValue();
        option.set(key,value,1, TimeUnit.MINUTES);
    }
    public String getValue(String key){
        ValueOperations<String ,String> operation = stringRedisTemplate.opsForValue();
        return operation.get(key);

    }
}
