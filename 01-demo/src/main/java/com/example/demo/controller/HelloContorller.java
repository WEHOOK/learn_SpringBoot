package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyu
 * @date 2020-06-18
 * @description
 */
@RestController
public class HelloContorller {
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}
