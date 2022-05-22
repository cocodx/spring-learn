package com.springframework.learn.readjson.properties;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 12/3/2022 上午3:42
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        CLassPathPropertyFileApplicationContext context = new CLassPathPropertyFileApplicationContext("spring.properties");
        Map<String,Employee> beansOfType = context.getBeansOfType(Employee.class);
        for (Map.Entry<String,Employee> entry: beansOfType.entrySet()){
            log.info("bean name:{},bean:{}",entry.getKey(),entry.getValue());
        }
        Techie techie = (Techie) context.getBean("techie");
        log.info(String.valueOf(techie));

        Set<String> strings = new HashSet<>();
    }
}
