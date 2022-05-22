package com.springframework.learn.entity;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/3/2022 下午11:02
 */
public class Class<T> {
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
