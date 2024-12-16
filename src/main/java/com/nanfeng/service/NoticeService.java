package com.nanfeng.service;

import com.nanfeng.pojo.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanfeng.utils.Result;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
* @author 29465
* @description 针对表【notice】的数据库操作Service
* @createDate 2024-12-13 16:07:01
*/
public interface NoticeService extends IService<Notice> {

    Result getAllNotice();

    Result setNotice(Notice notice);

    Result updateNotice(Notice notice);

    Result deleteNotice(Integer id);

    Result addNoticeList(MultipartFile file) throws IOException;

    List<Notice> getData(List<Integer> ids);
}
