package com.springframework.learn;

import com.springframework.learn.parentname.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 测试parentName属性
 * @date 9/3/2022 下午10:54
 */
public class UsingParentNameTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:parentName-beanDefinition.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        System.out.println(testBean);
    }
}
