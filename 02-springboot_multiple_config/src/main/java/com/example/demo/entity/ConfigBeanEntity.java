package com.example.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author gaoyu
 * @date 2020-06-19
 * @description 获取yml配置文件的内容
 */
@ConfigurationProperties(prefix = "my1")
@Component
public class ConfigBeanEntity {
    private String name;
    private int age;
    private int number;

    private String uuid;

    private int max;

    private String value;

    private String hehe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHehe() {
        return hehe;
    }

    public void setHehe(String hehe) {
        this.hehe = hehe;
    }
}
