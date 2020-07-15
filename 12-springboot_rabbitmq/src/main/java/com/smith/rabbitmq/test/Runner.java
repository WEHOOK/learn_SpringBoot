package com.smith.rabbitmq.test;

import com.smith.rabbitmq.util.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author gy
 * @date 2020-07-14
 * @description
 */
@Component
public class Runner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    private RabbitTemplate rabbitTemplate;
    private Receiver receiver;
    private ConfigurableApplicationContext context;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("send message");
        rabbitTemplate.convertAndSend("spring-boot","hello rabbitmq");
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
        context.close();
    }
}
