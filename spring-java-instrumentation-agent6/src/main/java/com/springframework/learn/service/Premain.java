package com.springframework.learn.service;

import java.lang.instrument.Instrumentation;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 22/1/2022 δΈε12:43
 */
public class Premain {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new FuckTransformer());
        System.out.println("premain ok!");
    }
}
