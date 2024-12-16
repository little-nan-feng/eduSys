package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Course;
import com.nanfeng.service.CourseService;
import com.nanfeng.mapper.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author 29465
* @description 针对表【course】的数据库操作Service实现
* @createDate 2024-12-08 15:45:46
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

}




