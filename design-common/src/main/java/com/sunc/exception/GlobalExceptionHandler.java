package com.sunc.exception;

import com.sunc.base.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler{
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public CommonResult error(BusinessException e){
        log.error(e.getMessage());
        return CommonResult.error(e.getMessage());
    }

    /**
     * 请求的 JSON 参数在请求体内的参数校验
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public CommonResult handlerValidException(MethodArgumentNotValidException e){

        String errMsg = StringUtils.collectionToCommaDelimitedString(
                            e.getBindingResult().getFieldErrors()
                            .stream()
                            .map(FieldError::getDefaultMessage)
                            .collect(Collectors.toList()));
        log.error("参数方法无效: ",e.getMessage());
        return CommonResult.error(errMsg);
    }

}
