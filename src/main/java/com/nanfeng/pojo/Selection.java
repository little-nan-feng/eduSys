package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName selection
 */
@TableName(value ="selection")
@Data
public class Selection implements Serializable {
    private String sId;

    private Integer cId;

    private static final long serialVersionUID = 1L;
}