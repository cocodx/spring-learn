package com.springframework.learn;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 23/1/2022 δΈε9:52
 */
@Aspect
public class ProfilingAspect {

    @Around("methodsToBeProfiled()")
    public Object profile(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("before");

        try {
            return pjp.proceed();
        } finally {
            System.out.println("after");
        }
    }

    @Pointcut("execution(public * com.springframework.learn..*.*(..))")
    public void methodsToBeProfiled(){}

}
