package com.example.demo.controller;

import com.example.demo.entity.ConfigBeanEntity;
import com.example.demo.entity.MyUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyu
 * @date 2020-06-19
 * @description
 */
@RestController
public class GetCusYmlValueController {
    @Autowired
    private MyUserEntity myUserEntity;
    @GetMapping("/getcusyml")
    public String getYml(){
        return myUserEntity.getHehe()+"\r\n"+
                myUserEntity.getName()+"\r\n"+
                myUserEntity.getUuid()+"\r\n"+
                myUserEntity.getValue()+"\r\n" +
                myUserEntity.getAge()+"\r\n"+
                myUserEntity.getMax()+"\r\n"+
                myUserEntity.getNumber();
    }

}
