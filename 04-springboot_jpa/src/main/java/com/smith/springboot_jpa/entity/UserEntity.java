package com.smith.springboot_jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
//@Entity(name = "student")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
