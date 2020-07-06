package com.smith.redis;

import com.smith.redis.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gaoyu
 * @date 2020-07-06
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTest {
    public static final Logger log = LoggerFactory.getLogger(SpringbootRedisApplicationTest.class);

    @Autowired
    private RedisDao redisDao;


    @Test
    public void testRedis(){
        redisDao.setkey("name","smith");
        redisDao.setkey("tel","12345");

        log.info(redisDao.getValue("name"));
        log.info(redisDao.getValue("tel"));

    }
}
