package com.springframework.learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 测试BeanFactoryProcessor和BeanDefinitionRegistryPostProcessor
 * @date 13/3/2022 上午2:33
 */
public class TestBeanFactoryProcessor {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.springframework.learn");

    }
}
