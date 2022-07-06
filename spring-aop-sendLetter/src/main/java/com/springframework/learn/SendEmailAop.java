package com.springframework.learn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author amazfit
 * @date 2022-07-07 上午12:31
 **/
//创建切面
@Component
@Aspect
public class SendEmailAop {

//    @Pointcut("execution(* org.apache.commons.mail.HtmlEmail.send(..))")  切不到，因为这个没有注入到spring里面去
    @Pointcut("execution(* com.springframework.learn.Test1Send.send1(..))")
    private void myPointCut(){}

    @Autowired
    private SendEmail sendEmail;

    @Before("myPointCut()")
    public void preSendEmail(JoinPoint joinPoint){
        System.out.println("在发送之前");
    }

    @AfterReturning(value = "myPointCut()",returning = "returnValue")
    public void clap(JoinPoint joinPoint,Object returnValue){
        System.out.println("发送成功");
    }

    /**
     * 这个就是对注入的spring的bean对象，使用HtmlEmail发送邮件的bean工具类进行代理，发送失败
     * aop切到了这个工具类send方法，发送失败，获取抛出异常（HtmlEmail的json数据），拿到之后，使用新的SendEmail类进行发送
     * @param joinPoint
     * @param throwable
     */
    @AfterThrowing(value = "myPointCut()",throwing = "throwable")
    public void sendError(JoinPoint joinPoint,Throwable throwable){
        System.out.println("发送失败，获取HtmlEmail对象");
        System.out.println("获取到htmlEmail的json数据为：-----------"+throwable.getMessage());
        sendEmail.preSend();
    }
}
