package com.springframework.learn;

import org.aspectj.weaver.loadtime.ClassPreProcessorAgentAdapter;
import org.springframework.instrument.InstrumentationSavingAgent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author 刘刚
 * @version 1.0
 * @description
 * @date 23/1/2022 下午8:35
 */
public class InstrumentationLoadTimeWeaving {

    public static void init() {
        addTransformer(new AspectJClassBypassingClassFileTransformer(new ClassPreProcessorAgentAdapter()));
    }

    public static void addTransformer(ClassFileTransformer transformer){
        Instrumentation instrumentation =getInstrumentation();
        if (instrumentation!=null){
            instrumentation.addTransformer(transformer);
        }
    }

    private static final boolean AGENT_CLASS_PERSENT =
            isPresent("org.springframework.instrument.InstrumentationSavingAgent",
                    InstrumentationLoadTimeWeaving.class.getClassLoader());

    public static Instrumentation getInstrumentation(){
        if (AGENT_CLASS_PERSENT){
            //获取保存起来的Instrumentation
            return InstrumentationAccessor.getInstrumentation();
        }else{
            return null;
        }
    }

    public static class InstrumentationAccessor{
        public static Instrumentation getInstrumentation(){
            return InstrumentationSavingAgent.getInstrumentation();
        }
    }

    public static boolean isPresent(String className,ClassLoader classLoader){
        try {
            classLoader.loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
