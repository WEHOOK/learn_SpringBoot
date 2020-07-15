package com.smith.rabbitmq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author gy
 * @date 2020-07-14
 * @description
 */
@Component
public class Receiver {

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        log.info("receive < "+message+" >");
        latch.countDown();

    }
    public CountDownLatch getLatch(){
        return latch;
    }

}
