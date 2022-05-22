package com.springframework.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 打印BeanDefinition json
 * @date 10/3/2022 下午10:03
 */
@Slf4j
public class PrintlnBeanDefinitionJson {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:readJson.xml");
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("testController");
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        filter.getExcludes().add("beanClass");
        log.info("testController:{}", JSON.toJSONString(beanDefinition,filter));

        BeanDefinition beanDefinition1 = beanFactory.getBeanDefinition("testService");
        log.info("testService:{}", JSON.toJSONString(beanDefinition1,filter));
    }
}
