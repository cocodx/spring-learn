本实验的逻辑在于：
1.通过agent的premain，将jvm暴露的instrumentation保存起来，到一个static的field里。
2.这样，在main方法执行前，我们已经把 instrumentation 存到了一个可以地方了，后续可以供我们使用。
3.然后，我们再把aspectJ的classFileTransformer设置到第二步获取到的instrumentation里。


执行步骤：
1.mvn clean package，得到jar包：spring-aspectj-integration-1.0-SNAPSHOT.jar

2.把aspectjweaver-1.8.2.jar和spring-instrument-4.3.7.RELEASE.jar拷贝到和本jar包同路径下

3.cmd下执行：
java -javaagent:spring-instrument-4.3.7.RELEASE.jar -cp spring-aspectj-integration-1.0-SNAPSHOT.jar;aspectjweaver-1.8.2.jar foo.Main