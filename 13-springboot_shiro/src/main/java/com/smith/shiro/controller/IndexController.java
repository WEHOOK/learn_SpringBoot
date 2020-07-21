package com.smith.shiro.controller;

import com.smith.shiro.entity.UserInfo;
import com.smith.shiro.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
@Controller
public class IndexController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping({"/","/tologin"})
    public String toLogin(){
        return "login";
    }

    @GetMapping("/getuser")
    @ResponseBody
    public UserInfo getUser(String name){
        return userInfoService.queryByName(name);
    }

    @PostMapping("/login")
    public String login(String username,String password){

        try {

            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            // 用户登录数据
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            // 执行登录方法，没有异常就登录成功了
            subject.login(usernamePasswordToken);
            return "index";

        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在");
        }
        catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        return "login";
    }


    @GetMapping("/add")
    public String add(){
        return "add";
    }

    @GetMapping("/del")
    public String del(){
        return "del";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }

    @GetMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginuser",null);
        return "login";
    }



}
