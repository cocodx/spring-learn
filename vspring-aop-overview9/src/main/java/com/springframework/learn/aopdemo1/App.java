package com.springframework.learn.aopdemo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 * 测试一下spring的aop增强
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"aop.xml"},false
        );
        applicationContext.refresh();
        //获取到代理对象，看下增强情况
        TestBean testBean = (TestBean) applicationContext.getBean("test");
        testBean.testPrintln();

    }
}
