package com.example.demo.controller;

import com.example.demo.entity.ConfigBeanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyu
 * @date 2020-06-19
 * @description
 */
@RestController
public class GetYmlConfigValueController {

    /**
     * 获取yml文件配置额内容
     */
    @Autowired
    private ConfigBeanEntity configBeanEntity;
    @GetMapping("/getyml")
    public String getYml(){
        return configBeanEntity.getHehe()+"\r\n"+
                configBeanEntity.getName()+"\r\n"+
                configBeanEntity.getUuid()+"\r\n"+
                configBeanEntity.getValue()+"\r\n" +
                configBeanEntity.getAge()+"\r\n"+
                configBeanEntity.getMax()+"\r\n"+
                configBeanEntity.getNumber();
    }
}
