package com.smith.rbac.shiro;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import com.smith.rbac.dao.SysPermissionMapper;
import com.smith.rbac.dao.SysRoleMapper;
import com.smith.rbac.dao.SysUserMapper;
import com.smith.rbac.entity.SysPermission;
import com.smith.rbac.entity.SysRole;
import com.smith.rbac.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gy
 * @date 2020-07-22
 * @description
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysPermissionMapper permissionMapper;
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String username = user.getUsername();
        System.out.println("用户" + username + "获取权限");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<SysRole> roleList = roleMapper.findUserRoleByName(username);
        System.out.println("用户" + username + "的角色集有：" + JSONUtil.toJsonStr(roleList));
        Set<String> roleSet = new HashSet<>();
        // 角色用户集
        for (SysRole sysRole : roleList) {
            roleSet.add(sysRole.getName());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        //获取用户权限集
        List<SysPermission> permissionList = permissionMapper.findUserPermByName(username);
        System.out.println("用户" + username + "的权限集有：" + JSONUtil.toJsonStr(permissionList));
        Set<String> permSet = new HashSet<>();
        for (SysPermission sysPermission : permissionList) {
            permSet.add(sysPermission.getName());
        }
        simpleAuthorizationInfo.setStringPermissions(permSet);

        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());


        System.out.println("用户"+username+"进行了认证");

        SysUser userResult = userMapper.selectByUserName(username);
        if(ArrayUtil.isEmpty(userResult)){
            throw new UnknownAccountException("用户名或密码错误");
        }
        if("0".equals(userResult)){
            throw new DisabledAccountException("账户已被禁用，请联系管理员");
        }
        if(!password.equals(userResult.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(userResult,userResult.getPassword(),getName());
    }
}
