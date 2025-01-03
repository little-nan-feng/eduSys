package com.nanfeng.service;

import com.nanfeng.pojo.College;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【college】的数据库操作Service
* @createDate 2024-12-08 15:45:46
*/
public interface CollegeService extends IService<College> {

    Result getCollege();
}
