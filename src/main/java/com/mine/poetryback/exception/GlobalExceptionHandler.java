package com.mine.poetryback.exception;

import com.mine.poetryback.pojo.Result;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {//全局异常处理器
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
//        e.printStackTrace();
        return Result.error(StringUtils.isNullOrEmpty(e.getMessage())? "操作失败" : e.getMessage());
    }
}
