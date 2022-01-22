package com.springframework.learn.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘刚
 * @version 1.0
 * @description 使用：context:property-placeholder
 * @date 18/1/2022 下午9:33
 */
public class TestPropertyPlaceholder {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:name-test-property-placeholder.xml"},false,null
        );
        context.refresh();

        Object bean = context.getBean(TestPropertiesVO.class);
        System.out.println(bean);
    }
}
