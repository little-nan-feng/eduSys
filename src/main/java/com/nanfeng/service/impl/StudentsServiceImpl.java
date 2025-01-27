package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.StringUtils;
import com.nanfeng.pojo.Admin;
import com.nanfeng.pojo.Students;
import com.nanfeng.pojo.User;
import com.nanfeng.service.StudentsService;
import com.nanfeng.mapper.StudentsMapper;
import com.nanfeng.utils.JwtHelper;
import com.nanfeng.utils.MD5Util;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 29465
* @description 针对表【students】的数据库操作Service实现
* @createDate 2024-12-08 15:45:46
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<Students> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Students::getSId, user.getId());
        Students loginStudent = studentsMapper.selectOne(lambdaQueryWrapper);

        if (loginStudent == null) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_ERROR);
        }

        if (!StringUtils.isNullOrEmpty(user.getPassword()) &&                MD5Util.encrypt(user.getPassword())
                        .equals(loginStudent.getSPassword())) {
//            登录成功
            String token = jwtHelper.createToken(loginStudent.getSId());

            Map data = new HashMap<>();
            data.put("token", token);

            //判断是否记住密码--是 则直接返回用户数据
            if (user.isChecked() == true) {
                loginStudent.setSPassword(user.getPassword());
                data.put("user",loginStudent);
            } else {
                //返回之前要把密码置空
                loginStudent.setSPassword(null);
                data.put("user",loginStudent);
            }

            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getAllStudent(Integer pageNum, Integer pageSize) {

        Page<Students> studentsPage = studentsMapper.selectPage(new Page<>(pageNum,pageSize), null);
        return Result.ok(studentsPage);
    }

    @Override
    public Result deleteStudent(String id) {

        LambdaQueryWrapper<Students> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Students::getSId,id);
        int i = studentsMapper.delete(lambdaQueryWrapper);
        return Result.build(i,ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result StuGetInfo(String sid) {

        LambdaQueryWrapper<Students> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Students::getSId,sid);
        Students students = studentsMapper.selectOne(lambdaQueryWrapper);

        List<Students> student=new ArrayList<>();
        student.add(students);
        return Result.ok(student);
    }

    @Override
    public Result updateStudent(Students student) {

        LambdaQueryWrapper<Students> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Students::getSId,student.getSId());
        int i = studentsMapper.update(student, lambdaQueryWrapper);
        return Result.build(i,ResultCodeEnum.SUCCESS);
    }
}




