package com.nanfeng.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.nanfeng.utils.myConverter;
import lombok.Data;

/**
 * @TableName testrange
 */
@TableName(value ="testrange")
@Data
public class Testrange implements Serializable {
    @ExcelIgnore
    private Integer id;

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("内容")
    private String content;

    @ExcelProperty(value = "创建时间",converter = myConverter.class)
    private Date time;

    private static final long serialVersionUID = 1L;
}