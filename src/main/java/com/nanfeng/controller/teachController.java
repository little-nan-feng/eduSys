package com.nanfeng.controller;

import com.nanfeng.service.TeachService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teach")
@CrossOrigin
public class teachController {

    @Autowired
    private TeachService teachService;

    @GetMapping("getTeach")
    public Result getTeach(@RequestParam("id") String id) {
        Result result = teachService.getTeach(id);
        return result;
    }
}
