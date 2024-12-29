package com.nanfeng.controller;


import com.nanfeng.pojo.Admin;
import com.nanfeng.pojo.Students;
import com.nanfeng.pojo.Teachers;
import com.nanfeng.pojo.User;
import com.nanfeng.service.AdminService;
import com.nanfeng.service.StudentsService;
import com.nanfeng.service.TeachersService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class userController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentsService studentsService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println(user);

        Result result = null;

//        分角色登录
        if (user.getRole().equals("admin")) {

            result = adminService.login(user);

        } else if (user.getRole().equals("tea")) {

            result = teachersService.login(user);
        } else {

            result = studentsService.login(user);
        }

        return result;
    }

    //    使用token解析用户信息
    @GetMapping("/getUser")
    public Result getUser(@RequestHeader String token) {

        Result result = teachersService.getTeacher(token);
        return result;
    }
}
