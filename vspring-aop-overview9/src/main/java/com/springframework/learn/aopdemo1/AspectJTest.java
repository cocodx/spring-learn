package com.springframework.learn.aopdemo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 刘刚
 * @version 1.0
 * @description spring-aop的包里面，还是用了Aspectj
 * @date 23/1/2022 下午11:46
 *
 */
//切面，由切点和通知动作组成，可以有很多个切点和通知动作，也可以单独做某一方面的切面，比如权限校验，比如日志写入
@Aspect
public class AspectJTest {

    //加入程序的一个切点（这个里面定义execution表达，通知的是哪些目标对象，spring一般是搞到方法）
    @Pointcut("execution(* *.testPrintln(..))")
    public void test(){}

    //通知动作，around是主动的，before和after是被动的
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("before");
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println("after");
        }
        return null;
    }
}
