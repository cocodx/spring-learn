package com.springframework.learn;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author amazfit
 * @date 2022-06-12 上午10:23
 **/
public class FactroyStudent implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
