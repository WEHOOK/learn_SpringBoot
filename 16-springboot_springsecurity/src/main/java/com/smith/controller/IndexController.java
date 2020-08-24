package com.smith.controller;


import com.smith.common.BaseResponse;
import com.smith.common.StatusCode;
import com.smith.entity.UserInfo;
import com.smith.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/tologin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/getuser")
    @ResponseBody
    public UserInfo getUser(String name) {
        return userInfoService.queryByName(name);
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public BaseResponse login(String username, String password) {
//        BaseResponse response = new BaseResponse(StatusCode.Success);
//
//        return response;
//    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

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
        return "redirect:/tologin";
    }


}
