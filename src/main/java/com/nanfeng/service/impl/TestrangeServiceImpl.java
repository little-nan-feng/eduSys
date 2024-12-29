package com.nanfeng.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.pojo.Notice;
import com.nanfeng.pojo.Testrange;
import com.nanfeng.service.TestrangeService;
import com.nanfeng.mapper.TestrangeMapper;
import com.nanfeng.utils.ExcelListener;
import com.nanfeng.utils.ExcelListenerRange;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 29465
 * @description 针对表【testrange】的数据库操作Service实现
 * @createDate 2024-12-19 16:29:56
 */
@Service
public class TestrangeServiceImpl extends ServiceImpl<TestrangeMapper, Testrange>
        implements TestrangeService {

    @Autowired
    TestrangeMapper testrangeMapper;

    @Override
    public Result getRange(Integer pageNum, Integer pageSize) {

        LambdaQueryWrapper<Testrange> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<Testrange> Testranges = testrangeMapper.selectPage(new Page<>(pageNum, pageSize), lambdaQueryWrapper);
        return Result.ok(Testranges);
    }

    @Override
    public Result setRange(Testrange testrange) {

        int i = testrangeMapper.insert(testrange);
        return Result.ok(i);
    }

    @Override
    public Result updateRange(Testrange testrange) {

        int i = testrangeMapper.updateById(testrange);
        return Result.ok(i);
    }

    @Override
    public Result deleteRange(Integer id) {

        int i = testrangeMapper.deleteById(id);
        return Result.ok(i);
    }

    @Override
    public Result addNoticeList(MultipartFile file) throws IOException {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(file.getInputStream(), Testrange.class, new ExcelListenerRange(new TestrangeServiceImpl())).sheet().doRead();
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}




