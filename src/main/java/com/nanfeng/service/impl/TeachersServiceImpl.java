package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.StringUtils;
import com.nanfeng.pojo.Teachers;
import com.nanfeng.pojo.User;
import com.nanfeng.service.TeachersService;
import com.nanfeng.mapper.TeachersMapper;
import com.nanfeng.utils.JwtHelper;
import com.nanfeng.utils.MD5Util;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29465
 * @description 针对表【teachers】的数据库操作Service实现
 * @createDate 2024-12-08 15:45:46
 */
@Service
public class TeachersServiceImpl extends ServiceImpl<TeachersMapper, Teachers>
        implements TeachersService {

    @Autowired
    TeachersMapper teachersMapper;

    @Autowired
    JwtHelper jwtHelper;

    @Override
    public Result login(User user) {

        LambdaQueryWrapper<Teachers> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Teachers::getTId, user.getId());
        Teachers loginTeacher = teachersMapper.selectOne(lambdaQueryWrapper);

        if (loginTeacher == null) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_ERROR);
        }

        if (!StringUtils.isNullOrEmpty(user.getPassword())
                && MD5Util.encrypt(user.getPassword()).equals(loginTeacher.getTPassword())) {
//            登录成功
            String token = jwtHelper.createToken(loginTeacher.getTId());

            Map data = new HashMap<>();
            data.put("token", token);

//            判断是否记住密码--是 则直接返回用户数据
            if (user.isChecked() == true) {
                loginTeacher.setTPassword(user.getPassword());
                data.put("user", loginTeacher);
            } else {
                //返回之前要把密码置空
                loginTeacher.setTPassword(null);
                data.put("user", loginTeacher);
            }

            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getTeacher(String token) {

//        先判断token是否有效 true过期
        boolean isExpiration = jwtHelper.checkToken(token);
        if (isExpiration) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        String tId = jwtHelper.getUserId(token);

        Teachers teachers = teachersMapper.selectById(tId);
        teachers.setTPassword("");
        Map data = new HashMap<>();
        data.put("loginTeacher", teachers);

        return Result.ok(data);
    }

    @Override
    public Result getAllTeacher(Integer pageNum, Integer pageSize) {

        Page<Teachers> page = teachersMapper.selectPage(new Page<>(pageNum, pageSize), null);
        return Result.ok(page);
    }

    @Override
    public Result createTeacher(Teachers teacher) {

        System.out.println(teacher);
        teacher.setTPassword(MD5Util.encrypt(teacher.getTPassword()));
//        这里还有点问题-
        int i = teachersMapper.insert(teacher);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result updateTeacher(Teachers teacher) {

        LambdaQueryWrapper<Teachers> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teachers::getTId, teacher.getTId());
        int i = teachersMapper.update(teacher,lambdaQueryWrapper);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result checkUsed(Integer id) {

        LambdaQueryWrapper<Teachers> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teachers::getTId, id);
        Teachers teacher = teachersMapper.selectOne(lambdaQueryWrapper);
        if (teacher != null) {
            return Result.build(null, ResultCodeEnum.ISUSED);
        }
        return null;
    }

    @Override
    public Result deleteTeacher(Integer id) {

        LambdaQueryWrapper<Teachers> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teachers::getTId, id);
        int i = teachersMapper.delete(lambdaQueryWrapper);
        return Result.build(i,ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result TeaGetInfo(String tid) {

        LambdaQueryWrapper<Teachers> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teachers::getTId, tid);
        Teachers teachers = teachersMapper.selectOne(lambdaQueryWrapper);
        List<Teachers> teachersList=new ArrayList<>();
        teachersList.add(teachers);
        return Result.ok(teachersList);
    }
}




