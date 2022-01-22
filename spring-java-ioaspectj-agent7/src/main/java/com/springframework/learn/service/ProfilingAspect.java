package com.springframework.learn.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 刘刚
 * @version 1.0
 * @description 切面类
 * @date 22/1/2022 下午2:21
 */
@Aspect
public class ProfilingAspect {

    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before");
        try {
            return pjp.proceed();
        } finally {
            System.out.println("after");
        }
    }

    //定义切点
    @Pointcut("execution(public * com.springframework.learn.service..*.*(..))")
    public void methodsToBeProfiled(){}
}
