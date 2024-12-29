package com.nanfeng.controller;

import com.nanfeng.pojo.Course;
import com.nanfeng.service.CourseService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/course")
@RestController
@CrossOrigin
public class courseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourse")
    public Result getCourse(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        Result result = courseService.getCourse(pageNum, pageSize);
        return result;
    }

    @PostMapping("setCourse")
    public Result setCourse(@RequestBody Course course) {
        Result result = courseService.setCourse(course);
        return result;
    }

    @PutMapping("/updateCourse")
    public Result updateCourse(@RequestBody Course course) {

        Result result = courseService.updateCourse(course);
        return result;
    }

    @DeleteMapping("/deleteCourse")
    public Result deleteCourse(@RequestParam("id") Integer id) {

        Result result = courseService.deleteCourse(id);
        return result;
    }

//    批量导入
    @PostMapping("/addCourseList")
    public Result addCourseList(@RequestParam("file")MultipartFile file) throws IOException {
        Result result = courseService.addCourseList(file);
        return result;

    }
}
