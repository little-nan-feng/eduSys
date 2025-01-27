package com.nanfeng.controller;

import com.nanfeng.pojo.Attend;
import com.nanfeng.service.AttendService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("attend")
@CrossOrigin
public class attendController {

    @Autowired
    private AttendService attendService;

    @GetMapping("getAttendInfo")
    public Result getAttendInfo() {

        //管理员获取考勤信息
        Result result = attendService.getAttendInfo();
        return result;
    }

    @PutMapping("updateAttendStatus")
    public Result updateAttendStatus(@RequestBody Attend attend) {

        Result result = attendService.updateAttendStatus(attend);
        return result;
    }

//    学生获取个人考勤信息
    @GetMapping("stuGetAttendInfo")
    public Result stuGetAttendInfo(@RequestParam("sname") String sname) {

        Result result = attendService.stuGetAttendInfo(sname);
        return result;
    }
}
