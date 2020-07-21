package com.smith.shiro.realm;

import com.smith.shiro.entity.UserInfo;
import com.smith.shiro.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("授权");
        SimpleAuthorizationInfo simInfo = new SimpleAuthorizationInfo();
        //获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        // 获取用户信息
        UserInfo userInfo = (UserInfo) subject.getPrincipal();
        simInfo.addStringPermission(userInfo.getPerm());
        return simInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 获取登录信息
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        System.out.println(userToken.getUsername());

        //获取用户名 密码  数据库取
        UserInfo userInfo = userInfoService.queryByName(userToken.getUsername());
        System.out.println(userInfo);

        if(null == userInfo){
            return null;
        }
        Session session = subject.getSession();
        session.setAttribute("loginuser",userInfo);

        // 判断登录的用户名密码
        if(!userToken.getUsername().equals(userInfo.getUsername())){
            return null;
        }

        //密码认证，shiro做
        return new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(),"");
    }
}
