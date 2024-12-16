package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.StringUtils;
import com.nanfeng.pojo.Admin;
import com.nanfeng.pojo.Teachers;
import com.nanfeng.service.AdminService;
import com.nanfeng.mapper.AdminMapper;
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
 * @description 针对表【admin】的数据库操作Service实现
 * @createDate 2024-12-08 15:45:45
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {


}




