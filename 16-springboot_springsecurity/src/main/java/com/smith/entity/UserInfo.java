package com.smith.entity;

import java.io.Serializable;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */

public class UserInfo implements Serializable {

    private String id;

    private String username;

    private String password;

    private String perm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }
}
