package org.example.manage.service;

import org.example.manage.model.SecurityUser;
import org.example.manage.model.User;
import org.example.manage.repository.UserRepository;
import org.example.manage.utils.ApiResponse;
import org.example.manage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    //注册
    public ApiResponse<String> register(Map<String,String>map){
        ApiResponse<String> res = new ApiResponse<>();
        // 检查用户名是否已存在
        if (userRepository.findByUsername(map.get("username")) != null) {
            res.setCode(400);
            res.setMsg("用户名已存在");
            return res;
        }
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(passwordEncoder.encode(map.get("password")));
        user.setPhone(map.get("phone"));
        user.setRole(User.Role.valueOf("CUSTOMER"));
        userRepository.save(user);
        res.setCode(200);
        res.setMsg("注册成功");
        res.setData("ok");
        return res;
    }

    //登录
    public Map<String,String> login(Map<String,String>map){
        Map<String,String> res = new HashMap<>();
        String phone = map.get("phone");
        User user = userRepository.findByPhone(phone);
        if (user == null) {
            res.put("code","400");
            res.put("message","用户不存在");
            return res;
        }
        if (!passwordEncoder.matches(map.get("password"), user.getPassword())) {
            res.put("code","400");
            res.put("message","密码错误");
            return res;
        }
        res.put("code","200");
        res.put("message","登录成功");
        res.put("role", user.getRole().toString());
        res.put("phone", user.getPhone());
        res.put("username", user.getUsername());
        res.put("id", user.getId().toString());
        //把JWT返回给前端
        String token = JwtUtil.createJWT(user.getId().toString());
        res.put("token", token);
        return res;
    }



    public User getStudentById(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public Map<String,String> changePassword(Map<String,String>map) {
        //根据 SecurityContextHolder 获取当前登录用户的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        User user = userRepository.findById(securityUser.getId()).orElse(null);

        Map<String,String> res = new HashMap<>();
        if (!passwordEncoder.matches(map.get("oldPassword"), user.getPassword())) {
            res.put("code","400");
            res.put("message","原密码错误");
            return res;
        }
        user.setPassword(passwordEncoder.encode(map.get("newPassword")));
        userRepository.save(user);
        res.put("code","200");
        res.put("message","修改成功");
        return res;
    }

}