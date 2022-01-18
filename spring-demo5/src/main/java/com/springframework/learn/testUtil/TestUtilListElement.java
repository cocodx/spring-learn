package com.springframework.learn.testUtil;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 使用util这个namespace的里面的list标签
 * @date 18/1/2022 下午8:57
 */
public class TestUtilListElement {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:name-test-list.xml"},false,null
        );
        context.refresh();

        Object object1 = context.getBean("testList");
        System.out.println(object1);

        Object object2 = context.getBean("testBeanList");
        System.out.println(object2);
    }
}
