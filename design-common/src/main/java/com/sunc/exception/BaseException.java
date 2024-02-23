package com.sunc.exception;

import com.sunc.enums.CommonErrorCode;
import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    private Integer code;
    private final Integer DEFAULT_ERROR_CODE = -1;
    public BaseException(){
    }
    public BaseException(Integer code, String message){
        super(message);
        this.code = code;
    }
    public BaseException(String message){
        super(message);
        this.code = DEFAULT_ERROR_CODE;
    }
    public BaseException(Throwable cause){
        super(cause);
    }
    public BaseException(String message, Throwable cause){
        super(message,cause);
    }
    public BaseException(CommonErrorCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }
}
