package com.springframework.learn.ltw;

import com.springframework.learn.aopdemo1.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 静态AOP使用
 * @date 24/1/2022 上午12:47
 */
public class LtwTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"ltw-aop.xml"},false
        );
        applicationContext.refresh();
        TestBean testBean = (TestBean) applicationContext.getBean("test");
        testBean.testPrintln();
    }
}
