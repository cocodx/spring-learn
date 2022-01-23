package com.springframework.learn.cglib1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 24/1/2022 上午12:32
 */
public class EnhancerDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        EnhancerDemo enhancerDemo = (EnhancerDemo) enhancer.create();
        enhancerDemo.test();
    }

    private static class MethodInterceptorImpl implements MethodInterceptor{

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.err.println("Before invoke "+method);
            Object result = methodProxy.invokeSuper(o,objects);
            System.out.println("after invoke"+method);
            return result;
        }
    }

    public void test(){
        System.out.println("EnhancerDemo test()");
    }
}
