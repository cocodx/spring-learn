package com.springframework.learn.service;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author 刘刚
 * @version 1.0
 * @description 注册一个字节码转换器
 * @date 22/1/2022 下午12:35
 */
public class FuckTransformer implements ClassFileTransformer {


    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.equals("com/springframework/learn/service/TargetClass")){
            ClassPool classPool = ClassPool.getDefault();

            try {

                CtClass class1 = classPool.get(className.replaceAll("/", "."));
                CtMethod ctMethod = class1.getDeclaredMethod("sayHello");
                if (!ctMethod.isEmpty()) {
                    ctMethod.insertBefore("System.out.println(\"before hello!!!\");");
                }
                return class1.toBytecode();
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
