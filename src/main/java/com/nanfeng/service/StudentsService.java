package com.nanfeng.service;

import com.nanfeng.pojo.Students;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;
import com.nanfeng.pojo.User;

/**
* @author 29465
* @description 针对表【students】的数据库操作Service
* @createDate 2024-12-08 15:45:46
*/
public interface StudentsService extends IService<Students> {

    Result login(User user);

    Result getAllStudent(Integer pageNum, Integer pageSize);

    Result deleteStudent(String id);

    Result StuGetInfo(String sid);

    Result updateStudent(Students student);
}
