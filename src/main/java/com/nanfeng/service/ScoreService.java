package com.nanfeng.service;

import com.nanfeng.pojo.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;

/**
* @author 29465
* @description 针对表【score】的数据库操作Service
* @createDate 2024-12-08 15:45:46
*/
public interface ScoreService extends IService<Score> {

    Result getScore();

    Result deleteScore(String sid, String cid);

    Result getScoreTea(String tid);

    Result createScore(Score score);

    Result getScoreStu(String sid);
}
