package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Students;
import com.nanfeng.service.StudentsService;
import com.nanfeng.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

/**
* @author 29465
* @description 针对表【students】的数据库操作Service实现
* @createDate 2024-12-08 15:45:46
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

}




