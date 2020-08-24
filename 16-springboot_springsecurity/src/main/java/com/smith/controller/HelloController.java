package com.smith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gy
 * @date 2020-08-24
 * @description
 */
@Controller
public class HelloController {
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
