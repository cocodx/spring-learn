package com.springframework.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 使用util这个namespace的里面的constant标签
 * @date 18/1/2022 上午1:21
 */
public class TestConstant {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"name-test-constant.xml"},false,null
        );
        applicationContext.refresh();

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        String[] names = beanFactory.getBeanDefinitionNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("chin.age");
        System.out.println(JSON.toJSONString(beanDefinition));


    }
}
