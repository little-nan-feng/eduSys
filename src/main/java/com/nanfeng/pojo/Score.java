package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName score
 */
@TableName(value ="score")
@Data
public class Score implements Serializable {
    private String sId;

    private Integer cId;

    private Integer score;

    private Integer averageScore;

    private Integer examScore;

    private static final long serialVersionUID = 1L;
}