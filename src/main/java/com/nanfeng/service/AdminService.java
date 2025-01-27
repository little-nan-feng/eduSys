package com.nanfeng.service;

import com.nanfeng.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.pojo.User;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【admin】的数据库操作Service
* @createDate 2024-12-08 15:45:45
*/
public interface AdminService extends IService<Admin> {

//    管理员登录
    Result login(User user);

    Result getAdmin();
}
