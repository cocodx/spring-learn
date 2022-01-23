package com.springframework.learn;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Hello world!
 *
 */
public class AspectJClassBypassingClassFileTransformer implements ClassFileTransformer

{

    private final ClassFileTransformer delegate;

    public AspectJClassBypassingClassFileTransformer(ClassFileTransformer delegate) {
        this.delegate = delegate;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        if (className.startsWith("org.aspectj") || className.startsWith("org/aspectj")){
            return classfileBuffer;
        }
        return this.delegate.transform(loader,className,classBeingRedefined,protectionDomain,classfileBuffer);
    }
}
