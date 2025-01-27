package com.nanfeng.controller;

import com.nanfeng.pojo.Leavet;
import com.nanfeng.service.LeavetService;
import com.nanfeng.utils.Result;
import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("leavet")
public class leavetController {

    @Autowired
    private LeavetService leavetService;

    //    获取请假信息
    @GetMapping("getLeaveInfo")
    public Result getLeaveInfo() {

        Result result = leavetService.getLeaveInfo();
        return result;
    }

    @PutMapping("updateLeaveStatus")
    public Result updateLeaveStatus(@RequestBody Leavet leavet) {

        Result result = leavetService.updateLeaveStatus(leavet);
        return result;
    }

    //    获取学生个人请假信息
    @GetMapping("getStuLeaveInfo")
    public Result getStuLeaveInfo(@RequestParam("sname") String sname) {
        Result result = leavetService.getStuLeaveInfo(sname);
        return result;
    }

//    发起申请
    @PostMapping("putApplication")
    public Result putApplication(@RequestBody Leavet leavet){
        Result result = leavetService.putApplication(leavet);
        return result;
    }
}
