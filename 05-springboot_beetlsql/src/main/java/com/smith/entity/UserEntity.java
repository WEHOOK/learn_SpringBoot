package com.smith.entity;


import org.beetl.sql.core.annotatoin.Table;

import java.io.Serializable;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */

@Table(name = "sys_user")
public class UserEntity implements Serializable {

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
