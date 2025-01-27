package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName leavet
 */
@TableName(value ="leavet")
@Data
public class Leavet implements Serializable {
    private Integer lId;

    private String lStu;

    private String lReason;

    private Date lTime;

    private Integer lDuration;

    private Object lStatus;

    private static final long serialVersionUID = 1L;
}