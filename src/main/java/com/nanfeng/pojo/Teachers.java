package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @TableName teachers
 */
@TableName(value ="teachers")
@Data
public class Teachers implements Serializable {
    @JsonProperty("account")
    @TableId
    private String tId;

    private String tName;

    private Object tGender;

    private Date tBirthday;

    private Object tDegree;

    @JsonProperty("psd")
    private String tPassword;

    private String tTelephone;

    private Object tPolitic;

    private String tAdmissionYear;

    private Integer tCollege;

    private String tWorkTime;

    private Object tTitle;

    private static final long serialVersionUID = 1L;
}