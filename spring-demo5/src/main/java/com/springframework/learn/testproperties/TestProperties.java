package com.springframework.learn.testproperties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 使用util这个namespace的里面的properties标签
 * @date 18/1/2022 下午8:45
 */
public class TestProperties {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"name-test-properties.xml"},false,null
        );
        context.refresh();

        Object o = context.getBean(TestPropertiesBean.class);
        System.out.println(o);
    }
}
