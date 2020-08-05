package com.smith.session.controller;


import com.smith.session.common.BaseResponse;
import com.smith.session.common.StatusCode;
import com.smith.session.entity.SysUser;
import com.smith.session.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author gy
 * @date 2020-07-16
 * @description
 */
@Controller
public class IndexController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/tologin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/list")
    @RequiresPermissions("user:user")
    @ResponseBody
    public List<SysUser> getUser() {
        return userInfoService.getUserList();
    }

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse login(String username, String password, Boolean rememberMe) {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {

            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            // 用户登录数据
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password,rememberMe);
            // 执行登录方法，没有异常就登录成功了
            subject.login(usernamePasswordToken);

        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在");
            return new BaseResponse(StatusCode.AccountValidateFail, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return new BaseResponse(StatusCode.AccountPasswordNotMatch, e.getMessage());
        }
        return response;
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @RequiresPermissions("user:add")
    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @RequiresPermissions("user:del")
    @GetMapping("/del")
    public String del() {
        return "delete";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @GetMapping("logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/tologin";
    }


}
