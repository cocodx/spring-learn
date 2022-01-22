package com.springframework.learn.context;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 测试使用context:annotation-config
 * @date 21/1/2022 上午4:21
 */
public class MainClassForTestAnnotationConfig {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"context-test-annotationconfig.xml"},false,null
        );
        context.refresh();
        System.out.println(context.getBean(TestController.class));


        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("testController");
        System.out.println(beanDefinition);
    }
}
