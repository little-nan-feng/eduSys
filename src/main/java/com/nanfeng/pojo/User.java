package com.nanfeng.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    @JsonProperty("account")
    private String id;

    @JsonProperty("psd")
    private String password;

    @JsonProperty("role")
    private String role;// 角色

    @JsonProperty("checked")
    private boolean checked;
}
