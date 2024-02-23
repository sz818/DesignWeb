package com.sunc.exception;

import com.sunc.enums.CommonErrorCode;
import lombok.Data;

import java.io.Serial;
@Data
public class BusinessException extends BaseException{
    @Serial
    private static final long serialVersionUID = 4289706156606303942L;
    private Integer code;
    public BusinessException(Integer code, String message){
        super(code,message);
    }
    public BusinessException(String message){
        super(message);
    }
    public BusinessException(Throwable cause){
        super(cause);
    }
    public BusinessException(String message, Throwable cause){
        super(message,cause);
    }
    public BusinessException(CommonErrorCode resultCode){
        super(resultCode);
    }
    @Override
    public String toString(){
        return "BusinessException{" + "code = " + code + ", message = " + this.getMessage();
    }
}
