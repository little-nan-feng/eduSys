package com.nanfeng.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nanfeng.utils.myConverter;
import lombok.Data;

/**
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {

    @TableId(type = IdType.AUTO)
    @ExcelIgnore
    private Integer cId;

    @ExcelProperty("课程名称")
    private String cName;

    @ExcelProperty("授课教师")
    private String cTeacher;

    @ExcelProperty("授课地点")
    private String cLocation;

    @ExcelProperty("课程学分")
    private Integer cCredit;

    @ExcelProperty("课程学时")
    private Integer cHours;

    @ExcelProperty("课程类型")
    private String cType;

    @ExcelProperty(value = "授课时间",converter = myConverter.class)
    private Date cTime;

    @ExcelProperty("课程状态")
    private String cStatus;

    private static final long serialVersionUID = 1L;
}