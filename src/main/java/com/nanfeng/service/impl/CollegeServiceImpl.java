package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.College;
import com.nanfeng.service.CollegeService;
import com.nanfeng.mapper.CollegeMapper;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 29465
* @description 针对表【college】的数据库操作Service实现
* @createDate 2024-12-08 15:45:46
*/
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College>
    implements CollegeService{

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public Result getCollege() {

        List<College> colleges = collegeMapper.selectList(null);
        return Result.ok(colleges);
    }
}




