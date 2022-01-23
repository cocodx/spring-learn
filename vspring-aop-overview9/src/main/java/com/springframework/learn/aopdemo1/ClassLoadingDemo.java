package com.springframework.learn.aopdemo1;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 23/1/2022 下午10:22
 */
public class ClassLoadingDemo {

    public static void main(String[] args) {
        //获取类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        ClassLoader parentClassLoader = classLoader.getParent();
        while (true){
            parentClassLoader = parentClassLoader.getParent();
            if (parentClassLoader==null){
                break;
            }
            System.out.println(parentClassLoader);
        }
    }
}
