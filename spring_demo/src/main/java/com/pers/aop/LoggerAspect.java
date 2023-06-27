package com.pers.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
// 这是一个切面对象
@Aspect
public class LoggerAspect {

    @Before("execution(public int com.pers.aop.CalImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "的参数是" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(public int com.pers.aop.CalImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, int result) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "的结果是" + result);
    }
}
