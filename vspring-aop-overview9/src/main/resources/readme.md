jdkdemo1：对jdk动态代理的一个demo
cglib1：对cglib动态代理的一个demo

cglib包底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码生成新的类。

静态AOP使用示例：
加载时织入LTW（load-time weaving），指的是在虚拟机载入字节码文件时动态织入AspectJ切面。
Spring框架的值为AspectJ LTW在动态织入过程中提供了更细粒度的控制。
