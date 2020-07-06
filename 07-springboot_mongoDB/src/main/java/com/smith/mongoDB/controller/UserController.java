package com.smith.mongoDB.controller;

import com.smith.mongoDB.entity.UserEntity;
import com.smith.mongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<UserEntity> getUser() {
        return userService.findAll();
    }

    @PostMapping(value = "/adduser")
    @ResponseBody
    public UserEntity addUser(String name, String tel) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setMobile(tel);
        UserEntity resultEntity = userService.addUser(user);
        return resultEntity;
    }


    @PostMapping(value = "/{id}")
    public UserEntity updateUser(@PathVariable("id") String id, @RequestParam(value = "name", required = true)
            String name, @RequestParam(value = "tel", required = true) String tel) {
        UserEntity user = new UserEntity();
        user.setId(id);
        user.setName(name);
        user.setMobile(tel);
        UserEntity resultEntity = userService.updateUser(user);
        return resultEntity;
    }

    @GetMapping(value = "/{id}")
    public Optional<UserEntity> findUserById(@PathVariable("id") String id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "/name/{name}")
    public List<UserEntity> findUserByName(@PathVariable("name") String name) {
        return userService.findUserByName(name);
    }


}
