package com.smith.springboot_jpa.controller;


import com.smith.springboot_jpa.entity.UserEntity;
import com.smith.springboot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        UserEntity userEntity = userService.add(user);
        return userEntity.toString();

    }


    @PostMapping(value = "/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestParam(value = "name", required = true)
            String name, @RequestParam(value = "tel", required = true) String tel) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setTel(tel);
        UserEntity userEntity = userService.update(user);
        return userEntity.toString();
    }

    @GetMapping(value = "/{id}")
    public Optional<UserEntity> findUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @PostMapping("del")
    public String delUser(Integer id){
        return userService.delete(id);
    }


}
