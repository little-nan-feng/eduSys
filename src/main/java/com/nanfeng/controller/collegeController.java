package com.nanfeng.controller;

import com.nanfeng.service.CollegeService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("college")
@CrossOrigin
public class collegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("getCollege")
    public Result getCollege(){

        Result result = collegeService.getCollege();
        return result;
    }
}
