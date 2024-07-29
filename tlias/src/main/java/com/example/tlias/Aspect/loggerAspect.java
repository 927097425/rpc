package com.example.tlias.Aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.tlias.mapper.loggerMapper;
import com.example.tlias.pojo.MyLog;
import com.example.tlias.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class loggerAspect {
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    loggerMapper loggerMapper;
    @Pointcut("execution(* com.example.tlias.service.*.d*(..))||execution(* com.example.tlias.service.*.i*(..))||execution(* com.example.tlias.service.*.u*(..))")
    public void pt(){};

    @Around("pt()")
    public Object logExcution(ProceedingJoinPoint pjp) throws Throwable {
        String jwt = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        String userid = (String) claims.get("username");
        LocalDateTime operateTime = LocalDateTime.now();
        String className = String.valueOf(pjp.getTarget().getClass());
        String methodName = String.valueOf(pjp.getSignature().getName());
        String methodPrams = Arrays.toString(pjp.getArgs());
        Long begin = System.currentTimeMillis();

        Object result = pjp.proceed();

        Long end = System.currentTimeMillis();
        String resultValue = JSONObject.toJSONString(result);
        Long excutedTime = end-begin;
        MyLog myLog = new MyLog(null,userid,operateTime,className,methodName,methodPrams,resultValue,excutedTime);
        loggerMapper.insertByLogger(myLog);
        return result;
    }
}
