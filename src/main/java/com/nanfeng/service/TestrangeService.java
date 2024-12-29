package com.nanfeng.service;

import com.nanfeng.pojo.Testrange;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
* @author 29465
* @description 针对表【testrange】的数据库操作Service
* @createDate 2024-12-19 16:29:57
*/
public interface TestrangeService extends IService<Testrange> {

    Result getRange(Integer pageNum,Integer pageSize);

    Result setRange(Testrange testrange);

    Result updateRange(Testrange testrange);

    Result deleteRange(Integer id);

    Result addNoticeList(MultipartFile file) throws IOException;
}
