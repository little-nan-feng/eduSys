package com.nanfeng.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @TableName score
 */
@TableName(value ="score")
@Data
public class Score implements Serializable {
    @JsonProperty("sId")
    private String sId;

    @JsonProperty("cId")
    private Integer cId;

    @JsonProperty("total")
    private Integer score;

    @JsonProperty("regular")
    private Integer averageScore;

    @JsonProperty("exam")
    private Integer examScore;

    private static final long serialVersionUID = 1L;
}