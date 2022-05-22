package com.springframework.learn.rule.impl;

import com.springframework.learn.rule.GirlFriendhandlerVersion2;
import com.springframework.learn.rule.ParseRule;
import org.xml.sax.Attributes;

public class CreateObjectParseRule implements ParseRule {

    private String attributeNameForObjectType;

    private ClassLoader loader;

    private GirlFriendhandlerVersion2 girlFriendhandlerVersion2;


    public CreateObjectParseRule(String attributeNameForObjectType, GirlFriendhandlerVersion2 girlFriendhandlerVersion2) {
        this.attributeNameForObjectType = attributeNameForObjectType;
        this.girlFriendhandlerVersion2 = girlFriendhandlerVersion2;
        //默认使用当前线程类加载器
        loader = Thread.currentThread().getContextClassLoader();
    }

    @Override
    public void startElement(Attributes attributes) {
        String clazzStr = attributes.getValue(attributeNameForObjectType);
        if (clazzStr == null) {
            throw new RuntimeException("element must has attribute :" + attributeNameForObjectType);
        }

        Class<?> clazz;
        try {
            clazz = loader.loadClass(clazzStr);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("class not found:" + clazzStr);
        }

        Object o;
        try {
            o = clazz.newInstance();
        }catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("new instance failed.");
        }
        girlFriendhandlerVersion2.push(o);
    }

    @Override
    public void body(String body) {

    }

    @Override
    public void endElement() {

    }
}
