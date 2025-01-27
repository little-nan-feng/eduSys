package com.nanfeng.controller;


import com.nanfeng.pojo.Admin;
import com.nanfeng.pojo.Students;
import com.nanfeng.pojo.Teachers;
import com.nanfeng.pojo.User;
import com.nanfeng.service.AdminService;
import com.nanfeng.service.StudentsService;
import com.nanfeng.service.TeachersService;
import com.nanfeng.utils.Result;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class userController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentsService studentsService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println(user);

        Result result = null;

//        分角色登录
        if (user.getRole().equals("admin")) {

            result = adminService.login(user);

        } else if (user.getRole().equals("tea")) {

            result = teachersService.login(user);
        } else {

            result = studentsService.login(user);
        }

        return result;
    }

    //    使用token解析用户信息
    @GetMapping("/getUser")
    public Result getUser(@RequestHeader String token) {

        Result result = teachersService.getTeacher(token);
        return result;
    }

    @GetMapping("getTeacher")
    public Result getTeacher(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        Result result = teachersService.getAllTeacher(pageNum, pageSize);
        return result;
    }

    @PostMapping("createTeacher")
    public Result createTeacher(@RequestBody Teachers teacher) {

        Result result = teachersService.createTeacher(teacher);
        return result;
    }

    @PutMapping("updateTeacher")
    public Result updateTeacher(@RequestBody Teachers teacher) {

        Result result = teachersService.updateTeacher(teacher);
        return result;
    }

    @PutMapping("updateStudent")
    public Result updateStudent(@RequestBody Students student) {
        System.out.println(student);
        Result result = studentsService.updateStudent(student);
        return result;
    }

    @GetMapping("checkUsed")
    public Result checkUsed(@RequestParam("id") Integer id) {
        Result result = teachersService.checkUsed(id);
        return result;
    }

    @DeleteMapping("deleteTeacher")
    public Result deleteTeacher(@RequestParam("id") Integer id) {
        Result result = teachersService.deleteTeacher(id);
        return result;
    }

//    获取管理员
    @GetMapping("getAdmin")
    public Result getAdmin() {

        Result result = adminService.getAdmin();
        return result;
    }

//    获取学生信息
    @GetMapping("getStudent")
    public Result getStudent(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        Result result = studentsService.getAllStudent(pageNum, pageSize);
        return result;
    }

    //删除学生信息
    @DeleteMapping("deleteStudent")
    public Result deleteStudent(@RequestParam("id") String id) {
        Result result = studentsService.deleteStudent(id);
        return result;
    }

//    教师获取个人信息
    @GetMapping("/teaGetInfo")
    public Result getTeacherInfo(@RequestParam("id") String tid) {
        Result result = teachersService.TeaGetInfo(tid);
        return result;
    }

//    获取学生个人信息
    @GetMapping("stuGetInfo")
    public Result getStudentInfo(@RequestParam("id") String sid) {

        Result result = studentsService.StuGetInfo(sid);
        return result;
    }
}
