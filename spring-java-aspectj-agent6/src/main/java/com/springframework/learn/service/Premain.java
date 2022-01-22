package com.springframework.learn.service;

import java.lang.instrument.Instrumentation;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 22/1/2022 下午12:43
 */
public class Premain {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new FuckTransformer());
        System.out.println("premain ok!");
    }
}
