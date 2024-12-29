package com.nanfeng.controller;

import com.nanfeng.pojo.Testrange;
import com.nanfeng.service.TestrangeService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/range")
public class testRangeController {

    @Autowired
    TestrangeService testrangeService;

    @GetMapping("/getRange")
    public Result getRange(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {

        Result result = testrangeService.getRange(pageNum, pageSize);
        System.out.println(result.getData());

        return result;
    }

    @PostMapping("/setRange")
    public Result setRange(@RequestBody Testrange testrange) {

        Result result = testrangeService.setRange(testrange);
        return result;
    }

    @PutMapping("/updateRange")
    public Result updateRange(@RequestBody Testrange testrange) {

        Result result = testrangeService.updateRange(testrange);
        return result;
    }

    @DeleteMapping("/deleteRange")
    public Result deleteRange(@RequestParam("id") Integer id) {
        Result result = testrangeService.deleteRange(id);
        return result;
    }

    @PostMapping("/addRangeList")
    public Result addRangeList(@RequestParam("file") MultipartFile file) throws IOException {
        Result result=testrangeService.addNoticeList(file);
        return result;
    }
}
