package com.nanfeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanfeng.mapper.*;
import com.nanfeng.pojo.*;
import com.nanfeng.service.ScoreService;
import com.nanfeng.utils.Result;
import com.nanfeng.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29465
 * @description 针对表【score】的数据库操作Service实现
 * @createDate 2024-12-08 15:45:46
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
        implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeachMapper teachMapper;

    @Autowired
    private SelectionMapper selectionMapper;

    @Override
    public Result getScore() {

        List<Map> dataList = new ArrayList<>();
        List<Score> scores = scoreMapper.selectList(null);

        for (Score score : scores) {

            Map data = new HashMap();

            LambdaQueryWrapper<Students> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(Students::getSId, score.getSId());
            data.put("sName", studentsMapper.selectOne(lambdaQueryWrapper).getSName());
            data.put("sId", studentsMapper.selectOne(lambdaQueryWrapper).getSId());

            LambdaQueryWrapper<Course> lambdaQueryWrapper2 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper2.eq(Course::getCId, score.getCId());
            Course course = courseMapper.selectOne(lambdaQueryWrapper2);
            data.put("cName", course.getCName());
            data.put("cTeacher", course.getCTeacher());
            data.put("cId", course.getCId());
            data.put("regular", score.getAverageScore());
            data.put("exam", score.getExamScore());
            data.put("total", score.getScore());
            dataList.add(data);

        }

        return Result.ok(dataList);
    }

    @Override
    public Result deleteScore(String sid, String cid) {

        LambdaQueryWrapper<Score> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Score::getSId, sid).eq(Score::getCId, cid);
        int i = scoreMapper.delete(lambdaQueryWrapper);
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result getScoreTea(String tid) {

        List<Map> dataList = new ArrayList<>();

//        根据授课信息 获取课程id
        LambdaQueryWrapper<Teach> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Teach::getTId, tid);
        List<Teach> teaches = teachMapper.selectList(lambdaQueryWrapper);
        for (Teach teach : teaches) {

//            根据课程id 获取选课信息
            LambdaQueryWrapper<Selection> lambdaQueryWrapper1 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper1.eq(Selection::getCId, teach.getCId());
            List<Selection> selections = selectionMapper.selectList(lambdaQueryWrapper1);
            for (Selection selection : selections) {

//                根据选课信息中的学生id 在学生表中获取学生信息
                LambdaQueryWrapper<Students> lambdaQueryWrapper2 = new LambdaQueryWrapper<>();
                lambdaQueryWrapper2.eq(Students::getSId, selection.getSId());
                List<Students> students = studentsMapper.selectList(lambdaQueryWrapper2);
                for (Students student : students) {

                    Map data = new HashMap();

//                    根据学生信息获取学生id和名字
                    data.put("sId", student.getSId());
                    data.put("sName", student.getSName());
//                    根据课程id 获取课程信息 id 名字
                    data.put("cId", teach.getCId());
                    String cName = courseMapper.selectOne(new LambdaQueryWrapper<Course>().eq(Course::getCId, teach.getCId())).getCName();
                    data.put("cName", cName);

//                    根据学生id和对应的课程id 在成绩表中获取成绩信息
                    LambdaQueryWrapper<Score> lambdaQueryWrapper3 = new LambdaQueryWrapper<>();
                    lambdaQueryWrapper3.eq(Score::getSId, student.getSId()).eq(Score::getCId, teach.getCId());
                    Score score = scoreMapper.selectOne(lambdaQueryWrapper3);

//                    如果该学生暂时还没有成绩 即成绩表中没有信息，则返回学生名字和课程名称
                    if(score == null){
//                    成绩为无
                        data.put("regular", "暂无成绩");
                        data.put("exam", "暂无成绩");
                        data.put("total", "暂无成绩");
                        dataList.add(data);
                        break;
                    }

//                    如果该学生已经有成绩，则返回成绩信息
                    data.put("regular", score.getAverageScore());
                    data.put("exam", score.getExamScore());
                    data.put("total", score.getScore());

//                    把map放到list中
                    dataList.add(data);
                }
            }
        }

//        返回整个list
        return Result.ok(dataList);
    }

    @Override
    public Result createScore(Score score) {

        LambdaQueryWrapper<Score> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Score::getSId, score.getSId()).eq(Score::getCId, score.getCId());

        int i = 0;
        if (scoreMapper.selectOne(lambdaQueryWrapper) == null) {
            i = scoreMapper.insert(score);
        } else {
            i = scoreMapper.update(score, lambdaQueryWrapper);
        }
        return Result.build(i, ResultCodeEnum.SUCCESS);
    }

    @Override
    public Result getScoreStu(String sid) {

        List<Map> dataList = new ArrayList<>();

        LambdaQueryWrapper<Score> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Score::getSId, sid);
        List<Score> scores = scoreMapper.selectList(lambdaQueryWrapper);

        for (Score score : scores) {
            Map data=new HashMap();

            String cName = courseMapper.selectOne(new LambdaQueryWrapper<Course>().eq(Course::getCId, score.getCId())).getCName();
            data.put("cName",cName);
            data.put("regular",score.getAverageScore());
            data.put("exam",score.getExamScore());
            data.put("total",score.getScore());
            dataList.add(data);
        }
        return Result.ok(dataList);
    }

}




