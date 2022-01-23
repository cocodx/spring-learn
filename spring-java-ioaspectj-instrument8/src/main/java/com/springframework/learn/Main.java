package com.springframework.learn;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 23/1/2022 下午9:54
 */
public class Main {

    public static void main(String[] args) {
        InstrumentationLoadTimeWeaving.init();

        NovelService service= new NovelService();

        service.execute();
    }
}
