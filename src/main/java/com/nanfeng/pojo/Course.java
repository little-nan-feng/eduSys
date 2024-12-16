package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {
    private Integer cId;

    private String cName;

    private String cTeacherId;

    private String cLocation;

    private Integer cCredit;

    private Integer cHours;

    private String cType;

    private Date cTime;

    private static final long serialVersionUID = 1L;
}