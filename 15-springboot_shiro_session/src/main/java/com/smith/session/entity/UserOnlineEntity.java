package com.smith.session.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gy
 * @date 2020-07-29
 * @description
 */
public class UserOnlineEntity implements Serializable {

    private String id;

    private String userId;

    private String username;

    private String host;

    private String systremHost;

    private String status;

    private Date startDateTime;

    private Date lastAccessTime;

    private Long timeout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSystremHost() {
        return systremHost;
    }

    public void setSystremHost(String systremHost) {
        this.systremHost = systremHost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }
}
