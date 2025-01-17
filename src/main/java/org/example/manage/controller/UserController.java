package org.example.manage.controller;


import org.example.manage.model.User;
import org.example.manage.repository.UserRepository;
import org.example.manage.service.UserService;
import org.example.manage.utils.ApiResponse;
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
    public ApiResponse<String> registerUser(@RequestBody Map<String,String>map) {

        return userService.register(map);
    }

    // 登录
    @PostMapping("/login")
    public ApiResponse<Map<String,String>> login(@RequestBody Map<String,String>map) {
        return userService.login(map);
    }


    @PostMapping("/getUser")
    public ApiResponse<User> getStudentById(@RequestBody Map<String, String> map) {
        User user = userService.getStudentById(map.get("id"));
        return new ApiResponse<User>(200, "success", user);
    }
    @PostMapping("/getUserByPhone")
    public ApiResponse<Map<String,String>> getUserByPhone(@RequestBody String phone) {
        User user = userService.getStudentByPhone(phone);
        //把user改成
        // {username: string;
        //  phone: string;
        //  photo: string;
        //  gender: string;
        //  password: string;}
        //的map形式
        Map<String,String> res = new HashMap<>();
        res.put("username",user.getUsername());
        res.put("phone",user.getPhone());
        res.put("photo","https://cn.bing.com/images/search?q=&view=detailv2&id=D6577D0F19C013E39C5B6B970EA6A360E90B6AA3&ccid=0nTEIoAl&iss=fav&FORM=SVIM01&idpview=singleimage&mediaurl=https%253a%252f%252ftupian.qqw21.com%252farticle%252fUploadPic%252f2021-1%252f202111921572761327.jpg&expw=400&exph=400&thid=OIP.0nTEIoAl_Bc1AeIEozQXEQAAAA&idpbck=1");
        res.put("gender","男");
        res.put("password",user.getPassword());

        return new ApiResponse<Map<String,String>>(200, "success", res);
    }

    //修改密码
    @PostMapping("/changePassword")
    public Map<String,String> changePassword(@RequestBody Map<String,String>map) {
        return userService.changePassword(map);
    }
}
