package com.nanfeng.controller;

import com.alibaba.excel.EasyExcel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.nanfeng.pojo.Notice;
import com.nanfeng.service.NoticeService;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

@RequestMapping("/notice")
@RestController
@CrossOrigin
public class noticeContrrller {

    @Autowired
    NoticeService noticeService;


    @GetMapping("/getNotice")
    public Result getNotice(){

        Result result=noticeService.getAllNotice();
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

    @PostMapping(value = "downloadNotice")
    public void downloadNotice(@RequestBody String idList, HttpServletResponse response) throws Exception {

        System.out.println(idList);
//      在业务层根据id集合查询到数据集合--交给easyExcel进行写操作
        ObjectMapper mapper=new ObjectMapper();
        List<Integer> ids=mapper.readValue(idList, new TypeReference<List<Integer>>(){});
        System.out.println(ids);
        List<Notice> data = noticeService.getData(ids);

//        easyExcel 写
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("教务通知", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream(), Notice.class).sheet("教务通知").doWrite(data);

    }
}
