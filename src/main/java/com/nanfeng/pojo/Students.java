package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName students
 */
@TableName(value ="students")
@Data
public class Students implements Serializable {
    private String sId;

    private String sName;

    private Object sGender;

    private Date sBirthday;

    private String sGraduate;

    private String sPassword;

    private String sTelephone;

    private Object sPolitic;

    private String sAdmissionYear;

    private Integer sCollege;

    private String sMajor;

    private String sClass;

    private Object sStatus;

    private static final long serialVersionUID = 1L;
}