package com.nanfeng.controller;


import com.nanfeng.pojo.Teachers;
import com.nanfeng.service.TeachersService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class userController {

    @Autowired
    TeachersService teachersService;

    @PostMapping("/login")
    public Result login(@RequestBody Teachers teachers) {

        System.out.println(teachers);
        Result result = teachersService.login(teachers);

        return result;
    }

//    使用token解析用户信息
    @GetMapping("/getTeacher")
    public Result getTeacher(@RequestHeader String token) {

        Result result = teachersService.getTeacher(token);
        return result;
    }
}
