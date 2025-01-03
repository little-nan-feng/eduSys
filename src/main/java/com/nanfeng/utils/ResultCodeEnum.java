package com.nanfeng.utils;

public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    ACCOUNT_ERROR(501,"用户不存在"),
    PASSWORD_ERROR(503,"密码错误"),
    NOTLOGIN(504,"notLogin"),
    ISUSED(505,"id已存在,请换一个");


    private Integer code;
    private String msg;
    ResultCodeEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

}
