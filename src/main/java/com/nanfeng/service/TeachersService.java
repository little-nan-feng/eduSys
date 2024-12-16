package com.nanfeng.service;

import com.nanfeng.pojo.Teachers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【teachers】的数据库操作Service
* @createDate 2024-12-08 15:45:46
*/
public interface TeachersService extends IService<Teachers> {

//    登录
    Result login(Teachers teachers);

//    根据token获取教师信息
    Result getTeacher(String token);
}