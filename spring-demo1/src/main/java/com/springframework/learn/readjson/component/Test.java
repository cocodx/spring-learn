package com.springframework.learn.readjson.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springframework.learn.readjson.TestController;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 测试 json转 java对象 ConstructorArgumentValues 是否有值
 * @date 11/3/2022 上午12:17
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ClassPathJsonApplicationContext context = new ClassPathJsonApplicationContext("classpath:spring.json");
        TestController testController = context.getBean(TestController.class);
        System.out.println(testController);

        //模拟BeanDefinition，里面放一个ConstructorArgumentValues，转换java对象是有值的
        //把get和set方法去掉的话，fastjson，再去转换java对象，是没有值的
//        JSONArray jsonArray = JSON.parseArray(StreamUtils.copyToString(Test.class.getClassLoader().getResourceAsStream("spring.json"), Charset.forName("UTF-8")));
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//            BeanDefinitionTest beanDefinition = JSON.toJavaObject(jsonObject,BeanDefinitionTest.class);
//            System.out.println(beanDefinition);
//        }
//        System.out.println(jsonArray);
    }
}
