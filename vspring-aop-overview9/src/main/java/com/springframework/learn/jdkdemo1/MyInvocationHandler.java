package com.springframework.learn.jdkdemo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 刘刚
 * @version 1.0
 * @description 自定义的InvocationHandler，用于对接口提供的方法进行增强
 * @date 24/1/2022 上午12:14
 */
public class MyInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在目标对象的方法执行之前，打印一下before
        System.out.println("----------------before---------------");

        //执行目标对象的方法
        Object result = method.invoke(target,args);

        //在目标对象的方法执行之后，打印一下before
        System.out.println("------------------after-----------------");
        return result;
    }

    /**
     * 获取目标对象的代理对象
     * @return 代理对象
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
    }
}
