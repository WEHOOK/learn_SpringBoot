package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyu
 * @date 2020-06-19
 * @description
 */
@RestController
public class MyController {
    /**
     * 通过@Value 获取写在yml中的配置文件的值
     */
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private String age;

    @GetMapping("/")
    public String myTest(){
        return name + age;
    }


}
