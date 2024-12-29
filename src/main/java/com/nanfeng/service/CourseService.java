package com.nanfeng.service;

import com.nanfeng.pojo.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
* @author 29465
* @description 针对表【course】的数据库操作Service
* @createDate 2024-12-20 19:44:50
*/
public interface CourseService extends IService<Course> {

    Result getCourse(Integer pageNum, Integer pageSize);

    Result setCourse(Course course);

    Result updateCourse(Course course);

    Result deleteCourse(Integer id);

    Result addCourseList(MultipartFile file) throws IOException;
}
