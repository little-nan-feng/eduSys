package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Attend;
import com.nanfeng.service.AttendService;
import com.nanfeng.mapper.AttendMapper;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 29465
* @description 针对表【attend】的数据库操作Service实现
* @createDate 2025-01-27 15:01:53
*/
@Service
public class AttendServiceImpl extends ServiceImpl<AttendMapper, Attend>
    implements AttendService{

    @Autowired
    private AttendMapper attendMapper;

//    管理员获取考勤信息
    @Override
    public Result getAttendInfo() {

        List<Attend> attends = attendMapper.selectList(null);
        return Result.ok(attends);
    }

//    更新考勤状态
    @Override
    public Result updateAttendStatus(Attend attend) {

        LambdaQueryWrapper<Attend> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Attend::getAId,attend.getAId());
        int i = attendMapper.update(attend, lambdaQueryWrapper);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result stuGetAttendInfo(String sname) {

        LambdaQueryWrapper<Attend> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Attend::getAStu,sname);
        List<Attend> attends = attendMapper.selectList(lambdaQueryWrapper);
        return Result.ok(attends);
    }
}




