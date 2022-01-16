package com.springframework.learn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;

import java.io.IOException;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 16/1/2022 上午9:00
 */
public class JsonPathApplicationContext extends AbstractRefreshableConfigApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
        JsonBeanDefinitionReader beanDefinitionReader = new JsonBeanDefinitionReader(beanFactory);
        beanDefinitionReader.setEnvironment(this.getEnvironment());
        beanDefinitionReader.setResourceLoader(this);
        this.loadBeanDefinitions(beanDefinitionReader);
    }

    private void loadBeanDefinitions(AbstractBeanDefinitionReader jsonBeanDefinitionReader){
        jsonBeanDefinitionReader.loadBeanDefinitions(getConfigLocations());
    }

    public JsonPathApplicationContext() {
    }

    public JsonPathApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    /**
     * 定义构造函数
     * @param configurations
     * @param refresh
     * @param parent
     */
    public JsonPathApplicationContext(String[] configurations,boolean refresh,ApplicationContext parent) {
        super(parent);
        setConfigLocations(configurations);
        if (refresh){
            refresh();
        }
    }
}
