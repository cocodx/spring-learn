package com.springframework.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author amazfit
 * @date 2022-07-07 上午12:50
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Test1Send test1Send = context.getBean(Test1Send.class);
        test1Send.send1();
    }
}
