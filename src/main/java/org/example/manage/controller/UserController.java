package org.example.manage.controller;


import org.example.manage.model.User;
import org.example.manage.repository.UserRepository;
import org.example.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册用户
    @PostMapping("/register")
    public Map<String,String> registerUser(@RequestBody Map<String,String>map) {
        return userService.register(map);
    }

    // 登录
    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String>map) {
        return userService.login(map);
    }

    @PostMapping("/getAllStudent")
    public List<User> getAllStudent() {
        return userService.getAllStudent();
    }

    @PostMapping("/delete")
    public Map<String,String> delete(@RequestBody Map<String, String> map) {
        return userService.delete(map.get("id"));
    }

    @PostMapping("/update")
    public Map<String,String> update(@RequestBody Map<String, String> map) {
        return userService.update(map);
    }

    @PostMapping("/getStudent")
    public User getStudentById(@RequestBody Map<String, String> map) {
        return userService.getStudentById(map.get("id"));
    }

    //修改密码
    @PostMapping("/changePassword")
    public Map<String,String> changePassword(@RequestBody Map<String,String>map) {
        return userService.changePassword(map);
    }
}
