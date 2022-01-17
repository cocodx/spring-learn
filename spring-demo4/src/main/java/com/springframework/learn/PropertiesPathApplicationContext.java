package com.springframework.learn;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;

import java.io.IOException;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 17/1/2022 上午12:23
 */
public class PropertiesPathApplicationContext extends AbstractRefreshableConfigApplicationContext  {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        propertiesBeanDefinitionReader.setEnvironment(getEnvironment());
        propertiesBeanDefinitionReader.setResourceLoader(this);
        this.loadBeanDefinitions(propertiesBeanDefinitionReader);
    }

    private void loadBeanDefinitions(AbstractBeanDefinitionReader beanDefinitionReader){
        beanDefinitionReader.loadBeanDefinitions(getConfigLocations());
    }

    public PropertiesPathApplicationContext() {
    }

    public PropertiesPathApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    public PropertiesPathApplicationContext(String[] configurations,boolean refresh,ApplicationContext parent) {
        super(parent);
        setConfigLocations(configurations);
        if (refresh){
            refresh();
        }
    }
}
