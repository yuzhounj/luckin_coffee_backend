package org.example.manage.service;

import org.example.manage.model.SecurityUser;
import org.example.manage.model.User;
import org.example.manage.repository.UserRepository;
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
    public Map<String,String> register(Map<String,String>map){
        Map<String,String> res = new HashMap<>();
        // 检查用户名是否已存在
        if (userRepository.findByUsername(map.get("username")) != null) {
            res.put("result","fail");
            res.put("message","用户名已存在");
            return res;
        }
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(passwordEncoder.encode(map.get("password")));
        user.setName(map.get("name"));
        user.setStudentId(map.get("studentId"));
        user.setDepartment(map.get("department"));
        user.setRole(User.Role.valueOf(map.get("role")));
        userRepository.save(user);
        res.put("result","success");
        res.put("message","注册成功");
        return res;
    }

    //登录
    public Map<String,String> login(Map<String,String>map){
        Map<String,String> res = new HashMap<>();
        String username = map.get("username");
        User user = userRepository.findByUsername(username);
        if (user == null) {
            res.put("result","fail");
            res.put("message","用户不存在");
            return res;
        }
        if (!passwordEncoder.matches(map.get("password"), user.getPassword())) {
            res.put("result","fail");
            res.put("message","密码错误");
            return res;
        }
        res.put("result","success");
        res.put("message","登录成功");
        res.put("role", user.getRole().toString());
        res.put("name", user.getName());
        res.put("id", user.getId().toString());
        res.put("studentId", user.getStudentId());
        res.put("department", user.getDepartment());
        //把JWT返回给前端
        String token = JwtUtil.createJWT(user.getId().toString());
        res.put("token", token);
        return res;
    }

    public List<User> getAllStudent() {
        // 返回所有学生信息, 用于管理员查看 (过滤掉老师信息)
        return userRepository.findAll().stream().filter(user -> user.getRole() == User.Role.STUDENT).toList();
    }

    public Map<String,String> delete(String id) {

        //根据 SecurityContextHolder 获取当前登录用户的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        User user = userRepository.findById(securityUser.getId()).orElse(null);

        if(user.getRole() != User.Role.TEACHER){
            Map<String,String> res = new HashMap<>();
            res.put("result","fail");
            res.put("message","权限不足");
            return res;
        }

        Map<String,String> res = new HashMap<>();
        userRepository.deleteById(Long.parseLong(id));
        res.put("result","success");
        res.put("message","删除成功");
        return res;
    }

    public Map<String,String> update(Map<String,String> map) {
        //根据 SecurityContextHolder 获取当前登录用户的信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        User user = userRepository.findById(securityUser.getId()).orElse(null);

        if(user.getRole() != User.Role.TEACHER&&user.getId()!=Long.parseLong(map.get("id"))){
            Map<String,String> res = new HashMap<>();
            res.put("result","fail");
            res.put("message","权限不足");
            return res;
        }
        user =userRepository.findById(Long.parseLong(map.get("id"))).orElse(null);
        Map<String,String> res = new HashMap<>();
        user.setName(map.get("name"));
        user.setStudentId(map.get("studentId"));
        user.setDepartment(map.get("department"));
        userRepository.save(user);
        res.put("result","success");
        res.put("message","更新成功");
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
            res.put("result","fail");
            res.put("message","原密码错误");
            return res;
        }
        user.setPassword(passwordEncoder.encode(map.get("newPassword")));
        userRepository.save(user);
        res.put("result","success");
        res.put("message","修改成功");
        return res;
    }

}