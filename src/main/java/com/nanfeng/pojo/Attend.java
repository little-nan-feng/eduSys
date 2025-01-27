package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName attend
 */
@TableName(value ="attend")
@Data
public class Attend implements Serializable {
    private Integer aId;

    private String aCourse;

    private String aTea;

    private String aStu;

    private Date aTime;

    private Object aStatus;

    private static final long serialVersionUID = 1L;
}