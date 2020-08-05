package com.smith.session.service.impl;

import com.smith.session.entity.SysUser;
import com.smith.session.entity.UserOnlineEntity;
import com.smith.session.service.SessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author gy
 * @date 2020-07-29
 * @description
 */
@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public List<UserOnlineEntity> getOnlineList() {
        List<UserOnlineEntity> list = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null) {
                UserOnlineEntity userOnlineEntity = new UserOnlineEntity();
                SimplePrincipalCollection principalCollection = (SimplePrincipalCollection)
                        session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
                userOnlineEntity.setUserId(user.getId());
                userOnlineEntity.setUsername(user.getUsername());
                userOnlineEntity.setId((String) session.getId());
                userOnlineEntity.setHost(session.getHost());
                userOnlineEntity.setStartDateTime(session.getStartTimestamp());
                userOnlineEntity.setLastAccessTime(session.getLastAccessTime());
                Long timeout = session.getTimeout();
                userOnlineEntity.setTimeout(timeout);
                userOnlineEntity.setStatus("在线");
                if (timeout == 0) {
                    userOnlineEntity.setStatus("离线");
                }
                list.add(userOnlineEntity);

            }
            return list;

        }

        return null;
    }

    @Override
    public boolean takeLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        sessionDAO.delete(session);
        return true;
    }
}
