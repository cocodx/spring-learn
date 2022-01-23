package com.springframework.learn.aopdemo1;

import lombok.Data;

/**
 * @author 刘刚
 * @version 1.0
 * @description 目标代理的对象
 * @date 23/1/2022 下午11:44
 */
@Data
public class TestBean {

    private String testStr = "testStr";

    public void testPrintln(){
        System.out.println(testStr);
    }
}
