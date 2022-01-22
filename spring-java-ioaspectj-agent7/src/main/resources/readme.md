Aspectj的LTW使用
aspectjweaver.jar

执行步骤：
1、mvn clean package，得到jar包：spring-java-ioaspectj-agent7-1.0-SNAPSHOT.jar
把aspectjweaver-1.8.2.jar拷到同一目录下,后面不用了，直接执行cmd那个命令就好了

2、cmd下执行：
java -javaagent:lib/aspectjweaver-1.8.2.jar -cp spring-java-ioaspectj-agent7-1.0-SNAPSHOT.jar com.springframework.learn.App