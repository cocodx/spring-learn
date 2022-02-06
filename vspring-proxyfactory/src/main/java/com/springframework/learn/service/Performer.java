package com.springframework.learn.service;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 7/2/2022 上午4:08
 */
public class Performer implements Perform {
    @Override
    public void sing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("男孩在唱歌");
    }

    public void eat(){
        System.out.println("男孩在吃饭");
    }
}
