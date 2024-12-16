package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName teach
 */
@TableName(value ="teach")
@Data
public class Teach implements Serializable {
    private String tId;

    private Integer cId;

    private static final long serialVersionUID = 1L;
}