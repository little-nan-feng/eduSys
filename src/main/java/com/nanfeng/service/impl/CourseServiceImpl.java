package com.nanfeng.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.mapper.TeachersMapper;
import com.nanfeng.pojo.Course;
import com.nanfeng.pojo.Notice;
import com.nanfeng.service.CourseService;
import com.nanfeng.mapper.CourseMapper;
import com.nanfeng.utils.ExcelListener;
import com.nanfeng.utils.ExcelListenerCourse;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
* @author 29465
* @description 针对表【course】的数据库操作Service实现
* @createDate 2024-12-20 19:44:50
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeachersMapper teachersMapper;

    @Override
    public Result getCourse(Integer pageNum, Integer pageSize) {

        Page<Course> courses = courseMapper.selectPage(new Page<>(pageNum, pageSize),null);
        return Result.ok(courses);
    }

    @Override
    public Result setCourse(Course course) {

        int i = courseMapper.insert(course);
        return Result.ok(i);
    }

    @Override
    public Result updateCourse(Course course) {

        int i = courseMapper.updateById(course);
        return Result.ok(i);
    }

    @Override
    public Result deleteCourse(Integer id) {

        int i = courseMapper.deleteById((id));
        return Result.ok(i);
    }

    @Override
    public Result addCourseList(MultipartFile file) throws IOException {

        EasyExcel.read(file.getInputStream(), Course.class, new ExcelListenerCourse(new CourseServiceImpl())).sheet().doRead();

        return Result.build(null,ResultCodeEnum.SUCCESS);
    }
}




