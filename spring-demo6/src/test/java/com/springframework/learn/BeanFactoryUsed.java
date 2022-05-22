package com.springframework.learn;

import com.springframework.learn.service.EduService;
import com.springframework.learn.service.impl.EduTeacherServiceImpl;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 使用BeanFactory测试Bean是不是延迟加载的
 * @date 7/3/2022 上午6:56
 */
@Data
@Slf4j
public class BeanFactoryUsed {

    @Test
    public void test(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建BeanDefinition
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(EduTeacherServiceImpl.class).getBeanDefinition();
        beanFactory.registerBeanDefinition("eduService",beanDefinition);

        System.out.println(beanFactory.containsBean("eduService"));
        System.out.println(beanFactory.getBeanDefinitionCount());
        log.info("beanDefinition的数量："+beanFactory.getBeanDefinitionCount());
        //get bean

        EduService eduService = (EduService) beanFactory.getBean("eduService");
        log.info("eduService:{}",eduService);

    }
}
