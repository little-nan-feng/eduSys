package com.nanfeng.service;

import com.nanfeng.pojo.Leavet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【leavet】的数据库操作Service
* @createDate 2025-01-26 21:08:30
*/
public interface LeavetService extends IService<Leavet> {

    Result getLeaveInfo();

    Result updateLeaveStatus(Leavet leavet);

    Result getStuLeaveInfo(String sname);

    Result putApplication(Leavet leavet);

}
