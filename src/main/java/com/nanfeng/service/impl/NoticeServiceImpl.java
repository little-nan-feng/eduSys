package com.nanfeng.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Notice;
import com.nanfeng.service.NoticeService;
import com.nanfeng.mapper.NoticeMapper;
import com.nanfeng.utils.ExcelListener;
import com.nanfeng.utils.ExcelUtil;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
* @author 29465
* @description 针对表【notice】的数据库操作Service实现
* @createDate 2024-12-13 16:07:01
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private ExcelUtil excelUtil;

    @Override
    public Result getAllNotice() {

        LambdaQueryWrapper<Notice> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Notice> notices = noticeMapper.selectList(lambdaQueryWrapper);
        return Result.ok(notices);
    }

    @Override
    public Result setNotice(Notice notice) {

        noticeMapper.insert(notice);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result updateNotice(Notice notice) {

        int i = noticeMapper.updateById(notice);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result deleteNotice(Integer id) {
        int i = noticeMapper.deleteById(id);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result addNoticeList(MultipartFile file) throws IOException {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(file.getInputStream(), Notice.class, new ExcelListener(new NoticeServiceImpl())).sheet().doRead();

        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    @Override
    public List<Notice> getData(List<Integer> ids) {
        LambdaQueryWrapper<Notice> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Notice> notices = noticeMapper.selectBatchIds(ids);
        return notices;
    }
}




