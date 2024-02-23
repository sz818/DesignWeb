package com.sunc.base;


import com.sunc.enums.CommonErrorCode;
import lombok.Data;

@Data
public class CommonResult<T> implements IErrorCode {
    private Integer code;
    private String message;
    private T data;


    private CommonResult(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    private CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public static <T> CommonResult<T> ok(){
        return new CommonResult<T>(CommonErrorCode.OK.getCode(), CommonErrorCode.OK.getMessage());
    }
    public static <T> CommonResult<T> error(CommonErrorCode commonErrorCode){
        return new CommonResult<T>(commonErrorCode.getCode(), commonErrorCode.getMessage());
    }
    public static <T> CommonResult<T> error(Integer code, String message){
        return new CommonResult<T>(code, message);
    }
    public static <T> CommonResult<T> error(String message){
        return new CommonResult<T>(CommonErrorCode.FAILED.getCode(), message);
    }
    public static <T> CommonResult<T> setResult(Integer code, String message, T data){
        return new CommonResult<T>(code,message,data);
    }
    public CommonResult<T> data(T data){
        this.data = data;
        return this;
    }
    public CommonResult<T> message(String message){
        this.message = message;
        return this;
    }
    public CommonResult<T> code(Integer code){
        this.code = code;
        return this;
    }
    @Override
    public Integer getCode(){
        return this.code;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
    public T getData() {
        return this.data;
    }


}
