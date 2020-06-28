package com.smith.controller;


import com.smith.entity.UserEntity;
import com.smith.service.UserService;
import org.beetl.sql.core.db.KeyHolder;
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

    @GetMapping(value = "/list")
    public List<UserEntity> getUser() {
        return userService.findUserList();
    }

    @PostMapping(value = "/adduser")
    @ResponseBody
    public String addUser(String name, String tel) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setTel(tel);
        KeyHolder res = userService.add(user);
        if (res.getInt() > 1) {
            return "adduser success";
        }
        return "adduser fail";

    }


    @PostMapping(value = "/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestParam(value = "name", required = true)
            String name, @RequestParam(value = "tel", required = true) String tel) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setTel(tel);
        Integer res = userService.update(user);
        if (res == 1) {
            return "updateuser success";
        }
        return "updateuser fail";
    }

    @GetMapping(value = "/{id}")
    public UserEntity findUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "/name/{name}")
    public UserEntity findUserByName(@PathVariable("name") String name) {
        return userService.findUserByName(name);
    }


    @PostMapping("del")
    public String delUser(Integer id) {
        Integer res = userService.delete(id);
        if (res == 1) {
            return "deluser success";
        }
        return "deluser fail";
    }


}
