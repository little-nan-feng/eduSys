package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.mapper.CourseMapper;
import com.nanfeng.pojo.Course;
import com.nanfeng.pojo.Selection;
import com.nanfeng.service.SelectionService;
import com.nanfeng.mapper.SelectionMapper;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 29465
* @description 针对表【selection】的数据库操作Service实现
* @createDate 2024-12-08 15:45:46
*/
@Service
public class SelectionServiceImpl extends ServiceImpl<SelectionMapper, Selection>
    implements SelectionService{
    
    @Autowired
    private SelectionMapper selectionMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Result getSelection(String id) {

//        1、先根据传过来的学生id，去选课表里查询对对应的课程id
//        2、然后用课程id去课程表里查询课程信息
//        3、返回

//       准备一个list，来存储查询到的课程信息
        List<Course> selectCourse = new ArrayList<>();

//      1、查询课程id
        LambdaQueryWrapper<Selection> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Selection::getSId,id);
        List<Selection> selectionCourse = selectionMapper.selectList(lambdaQueryWrapper);

//      2、查询课程
        for (Selection selection : selectionCourse) {
            Integer courseId = selection.getCId();
            Course course = courseMapper.selectById(courseId);
            selectCourse.add(course);
        }

        return Result.ok(selectCourse);
    }

    @Override
    public Result setSelection(String sid, Integer cid) {
        Selection selection= new Selection();
        selection.setSId(sid);
        selection.setCId(cid);

        selectionMapper.insert(selection);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result deleteSelection(String sid, Integer cid) {

        LambdaQueryWrapper<Selection> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Selection::getSId,sid).eq(Selection::getCId,cid);

        int i = selectionMapper.delete(lambdaQueryWrapper);
        return Result.build(i,ResultCodeEnum.SUCCESS);
    }


}




