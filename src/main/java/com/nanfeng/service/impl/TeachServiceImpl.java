package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.mapper.CourseMapper;
import com.nanfeng.pojo.Course;
import com.nanfeng.pojo.Teach;
import com.nanfeng.service.TeachService;
import com.nanfeng.mapper.TeachMapper;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 29465
* @description 针对表【teach】的数据库操作Service实现
* @createDate 2024-12-08 15:45:46
*/
@Service
public class TeachServiceImpl extends ServiceImpl<TeachMapper, Teach>
    implements TeachService{

    @Autowired
    private TeachMapper teachMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Result getTeach(String id) {

        List<Course> courseList=new ArrayList<>();

        LambdaQueryWrapper<Teach> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teach::getTId,id);
        List<Teach> teaches = teachMapper.selectList(lambdaQueryWrapper);
        for (Teach teach : teaches) {
            Course course = courseMapper.selectById(teach.getCId());
            courseList.add(course);
        }
        return Result.ok(courseList);
    }
}




