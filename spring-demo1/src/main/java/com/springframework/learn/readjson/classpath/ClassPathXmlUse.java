package com.springframework.learn.readjson.classpath;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 15/3/2022 上午7:09
 */
public class ClassPathXmlUse {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beanDefinition.xml");
    }
}
