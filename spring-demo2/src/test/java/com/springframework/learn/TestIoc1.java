package com.springframework.learn;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 13/3/2022 上午1:13
 */
public class TestIoc1 {

    @Test
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
    }
}
