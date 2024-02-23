package com.sunc.enums;

import com.sunc.base.IErrorCode;

public enum CommonErrorCode implements IErrorCode {
    OK(200,"操作成功"),
    SYS_EXCEPTION(-1,"系统出现异常"),
    ERR_PARAM_NOT_LEGAL(2001,"参数非法"),
    REPEATED_OPERAATE(2002,"请勿重复操作"),
    ERR_CONSTRAINT_VIOLATION(2003,"数据库记录重复"),
    FAILED(500,"操作失败");


    private Integer code;
    private String message;
    CommonErrorCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
