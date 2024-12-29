package com.nanfeng.controller;

import com.alibaba.excel.EasyExcel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanfeng.pojo.Notice;
import com.nanfeng.service.NoticeService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RequestMapping("/notice")
@RestController
@CrossOrigin
public class noticeController {

    @Autowired
    NoticeService noticeService;


    @GetMapping("/getNotice")
    public Result getNotice(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){

        Result result=noticeService.getAllNotice(pageNum,pageSize);
        return result;
    }

    @PostMapping("/setNotice")
    public Result addNotice(@RequestBody Notice notice){

        Result result=noticeService.setNotice(notice);
        return result;
    }

    @PutMapping("/updateNotice")
    public Result updateNotice(@RequestBody Notice notice){
        Result result=noticeService.updateNotice(notice);
        return result;
    }

    @DeleteMapping("/deleteNotice")
    public Result deleteNotice(@RequestParam("id") Integer id){
        Result result=noticeService.deleteNotice(id);
        return result;
    }

    @PostMapping("addNoticeList")
    public Result addNoticeList(@RequestParam("file") MultipartFile file) throws IOException {
        Result result=noticeService.addNoticeList(file);
        return result;
    }

}
