package com.springframework.learn;

/**
 * @author εε
 * @version 1.0
 * @description
 * @date 23/1/2022 δΈε9:54
 */
public class Main {

    public static void main(String[] args) {
        InstrumentationLoadTimeWeaving.init();

        NovelService service= new NovelService();

        service.execute();
    }
}
