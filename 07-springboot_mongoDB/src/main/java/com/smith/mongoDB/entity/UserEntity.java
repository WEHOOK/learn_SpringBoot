package com.smith.mongoDB.entity;

import org.springframework.data.annotation.Id;

/**
 * @author gaoyu
 * @date 2020-07-06
 * @description
 */
public class UserEntity {
    @Id
    private String id;

    private String name;

    private String mobile;

    public UserEntity() {
    }

    public UserEntity(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
