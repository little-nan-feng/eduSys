package com.nanfeng.controller;

import com.nanfeng.pojo.Score;
import com.nanfeng.service.ScoreService;
import com.nanfeng.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
@CrossOrigin
public class scoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/getScore")
    public Result getScore() {

        Result result = scoreService.getScore();
        return result;
    }

    @DeleteMapping("deleteScore")
    public Result deleteScore(@RequestParam("sId") String sid, @RequestParam("cId") String cid) {

        Result result=scoreService.deleteScore(sid,cid);
        return result;
    }

//    教师获取成绩信息
    @GetMapping("/getScoreTea")
    public Result getScoreTea(@RequestParam("id") String tid) {

        Result result = scoreService.getScoreTea(tid);
        return result;
    }

    @PostMapping("createScore")
    public Result createScore(@RequestBody Score score) {

        System.out.println(score);
        Result result = scoreService.createScore(score);
        return result;
    }

    @GetMapping("getScoreStu")
    public Result getScoreStu(@RequestParam("id") String sid) {
        Result result = scoreService.getScoreStu(sid);
        return result;
    }
}
