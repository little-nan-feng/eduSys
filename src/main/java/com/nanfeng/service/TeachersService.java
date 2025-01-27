package com.nanfeng.service;

import com.nanfeng.pojo.Teachers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.pojo.User;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【teachers】的数据库操作Service
* @createDate 2024-12-08 15:45:46
*/
public interface TeachersService extends IService<Teachers> {

//    登录
    Result login(User user);

//    根据token获取教师信息
    Result getTeacher(String token);

    Result getAllTeacher(Integer pageNum,Integer pageSize);

    Result createTeacher(Teachers teacher);

    Result updateTeacher(Teachers teacher);

    Result checkUsed(Integer id);

    Result deleteTeacher(Integer id);

    Result TeaGetInfo(String tid);
}
