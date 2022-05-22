package com.springframework.learn;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 测试muTablePropertyValues
 * @date 9/3/2022 下午11:25
 */
public class UsingMuTablePropertyValues {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:muTablePropertyValues-beanDefinition.xml");
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("testBean");
        System.out.println(beanDefinition);

    }
}
