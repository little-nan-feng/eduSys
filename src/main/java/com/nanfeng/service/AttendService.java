package com.nanfeng.service;

import com.nanfeng.pojo.Attend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【attend】的数据库操作Service
* @createDate 2025-01-27 15:01:53
*/
public interface AttendService extends IService<Attend> {

//    管理员获取考勤信息
    Result getAttendInfo();

    Result updateAttendStatus(Attend attend);

    Result stuGetAttendInfo(String sname);
}
