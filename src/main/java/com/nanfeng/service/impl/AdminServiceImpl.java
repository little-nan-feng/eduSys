package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.StringUtils;
import com.nanfeng.mapper.TeachersMapper;
import com.nanfeng.pojo.Admin;
import com.nanfeng.pojo.Teachers;
import com.nanfeng.pojo.User;
import com.nanfeng.service.AdminService;
import com.nanfeng.mapper.AdminMapper;
import com.nanfeng.utils.JwtHelper;
import com.nanfeng.utils.MD5Util;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29465
 * @description 针对表【admin】的数据库操作Service实现
 * @createDate 2024-12-08 15:45:45
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private TeachersMapper teachersMapper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Admin::getTId, user.getId());
        Admin loginAdmin = adminMapper.selectOne(lambdaQueryWrapper);

        if (loginAdmin == null) {
            return Result.build(null, ResultCodeEnum.ACCOUNT_ERROR);
        }

        if (!StringUtils.isNullOrEmpty(user.getPassword()) &&
                MD5Util.encrypt(user.getPassword())
                        .equals(teachersMapper.selectById(loginAdmin.getTId()).getTPassword())) {
//            登录成功
//            生成token
            String token = jwtHelper.createToken(loginAdmin.getTId());

//            查询到管理员信息一起返回
            Teachers teachers = teachersMapper.selectById(loginAdmin.getTId());

            Map data = new HashMap<>();
            data.put("token", token);

//            判断是否记住密码--是 则直接返回用户数据
            if (user.isChecked() == true) {
                teachers.setTPassword(user.getPassword());
                data.put("user", teachers);
            } else {
                //否则返回之前把密码置空
                teachers.setTPassword(null);
                data.put("user", teachers);
            }

            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

//    获取管理员信息
    @Override
    public Result getAdmin() {

        List<Admin> admins = adminMapper.selectList(null);
        List<Teachers> adminList=new ArrayList<>();

        for (Admin admin : admins) {

            Teachers teacherAdmin = teachersMapper.selectById(admin.getTId());
            adminList.add(teacherAdmin);
        }
        
        return Result.ok(adminList);
    }
}




