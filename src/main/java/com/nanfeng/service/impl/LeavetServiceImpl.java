package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Leavet;
import com.nanfeng.service.LeavetService;
import com.nanfeng.mapper.LeavetMapper;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 29465
* @description 针对表【leavet】的数据库操作Service实现
* @createDate 2025-01-26 21:08:30
*/
@Service
public class LeavetServiceImpl extends ServiceImpl<LeavetMapper, Leavet>
    implements LeavetService{

    @Autowired
    private LeavetMapper leavetMapper;

    @Override
    public Result getLeaveInfo() {

        List<Leavet> leavets = leavetMapper.selectList(null);
        return Result.ok(leavets);
    }

    @Override
    public Result updateLeaveStatus(Leavet leavet) {

        LambdaQueryWrapper<Leavet> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Leavet::getLId,leavet.getLId());
        int i = leavetMapper.update(leavet, lambdaQueryWrapper);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result getStuLeaveInfo(String sname) {

        LambdaQueryWrapper<Leavet> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Leavet::getLStu,sname);
        List<Leavet> leavets = leavetMapper.selectList(lambdaQueryWrapper);
        return Result.ok(leavets);
    }

    @Override
    public Result putApplication(Leavet leavet) {

        int i = leavetMapper.insert(leavet);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

}




