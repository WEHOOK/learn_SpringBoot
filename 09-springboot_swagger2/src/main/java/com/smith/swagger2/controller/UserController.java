package com.smith.swagger2.controller;


import com.smith.swagger2.entity.UserEntity;
import com.smith.swagger2.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoyu
 * @date 2020-06-22
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    @GetMapping(value = "/list")
    public List<UserEntity> getUser() {
        return userService.findUserList();
    }

    @PostMapping(value = "/adduser")
    @ResponseBody
    @ApiOperation(value = "增加用户")
    @ApiParam()
    public String addUser(String name, String tel) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setTel(tel);
        int count = userService.add(user);
        if (1 == count) {
            return "add success";
        }
        return "add fail";
    }


    @PostMapping(value = "/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestParam(value = "name", required = true)
            String name, @RequestParam(value = "tel", required = true) String tel) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setTel(tel);
        int count = userService.update(user);
        if (1 == count) {
            return "update success";
        }
        return "update fail";
    }

    @GetMapping(value = "/{id}")
    public UserEntity findUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }


    /**
     * 开启事务
     * @param money
     */
    @PostMapping(value = "/update/transactional")
    public void updateTransational(String money){
        userService.updateTransactional(money);
    }


}
