package com.example.tlias.excepection;

import com.example.tlias.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class excepectionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception exp){
        exp.printStackTrace();
        return Result.error("抱歉，操作失败请联系管理员");
    }
}
