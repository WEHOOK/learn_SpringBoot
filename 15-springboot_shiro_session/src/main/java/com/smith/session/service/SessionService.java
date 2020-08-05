package com.smith.session.service;

import com.smith.session.entity.UserOnlineEntity;

import java.util.List;

/**
 * @author gy
 * @date 2020-07-29
 * @description
 */

public interface SessionService {

    /**
     * 获取在线用户
     * @return  list
     */
    List<UserOnlineEntity> getOnlineList();

    /**
     * 下线
     * @param sessionId sessionid
     * @return boolean
     */
    boolean takeLogout(String sessionId);

}
