package com.springframework.learn.entity;

/**
 * 对应coder.xml的文件
 */
public class Coder {

    private String name;
    private String sex;
    private String love;

    private Girl girl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Coder{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", love='" + love + '\'' +
                ", girl=" + girl +
                '}';
    }
}
