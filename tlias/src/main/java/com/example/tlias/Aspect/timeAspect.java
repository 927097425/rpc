package com.example.tlias.Aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class timeAspect {
    @Around("execution(* com.example.tlias.service.*.*(..))")
    public Object countRuntime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();
        System.out.println("runtime use "+(end-begin));
        return result;
    }
}
