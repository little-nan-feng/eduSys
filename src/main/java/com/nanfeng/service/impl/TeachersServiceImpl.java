package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.StringUtils;
import com.nanfeng.pojo.Teachers;
import com.nanfeng.service.TeachersService;
import com.nanfeng.mapper.TeachersMapper;
import com.nanfeng.utils.JwtHelper;
import com.nanfeng.utils.MD5Util;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Result login(Teachers teachers) {

        LambdaQueryWrapper<Teachers> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Teachers::getTId, teachers.getTId());
        Teachers loginTeacher = teachersMapper.selectOne(lambdaQueryWrapper);

        if (loginTeacher == null) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_ERROR);
        }

        if (!StringUtils.isNullOrEmpty(teachers.getTPassword())
                && MD5Util.encrypt(teachers.getTPassword()).equals(loginTeacher.getTPassword())) {
//            登录成功
            String token = jwtHelper.createToken(teachers.getTId());

            Map data=new HashMap<>();
            data.put("token",token);

            return Result.ok(data);

        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getTeacher(String token) {

//        先判断token是否有效 true过期
        boolean isExpiration = jwtHelper.checkToken(token);
        if (isExpiration){
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        String tId = jwtHelper.getUserId(token);

        Teachers teachers = teachersMapper.selectById(tId);
        teachers.setTPassword("");
        Map data=new HashMap<>();
        data.put("loginTeacher",teachers);

        return Result.ok(data);
    }
}




