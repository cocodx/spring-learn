package com.springframework.learn.componentscan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 22/1/2022 δΈε11:55
 */
public class MainClassForTestComponentScan {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:context-namespace-test-component-scan.xml"},false
        );
        context.refresh();

        System.out.println(context.getBean(PersonTestController.class));
    }
}
