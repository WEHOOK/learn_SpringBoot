package com.smith.springcache.component;

import com.smith.springcache.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author gaoyu
 * @date 2020-07-13
 * @description
 */
@Component
public class AppRunner implements CommandLineRunner {

    private final UserDao userDao;

    private static final Logger log = LoggerFactory.getLogger(AppRunner.class);


    public AppRunner(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("query start");
        log.info("1---->" + userDao.getUserList(1));
        log.info("2---->" + userDao.getUserList(2));
        log.info("3---->" + userDao.getUserList(3));
        log.info("4---->" + userDao.getUserList(4));
        log.info("5---->" + userDao.getUserList(5));
        log.info("6---->" + userDao.getUserList(6));
        log.info("7---->" + userDao.getUserList(7));

        log.info("1---->" + userDao.getUserList(1));
        log.info("2---->" + userDao.getUserList(2));
        log.info("3---->" + userDao.getUserList(3));
        log.info("4---->" + userDao.getUserList(4));
        log.info("5---->" + userDao.getUserList(5));
        log.info("6---->" + userDao.getUserList(6));
        log.info("7---->" + userDao.getUserList(7));

    }
}
