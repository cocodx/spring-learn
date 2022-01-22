
执行步骤：
1、mvn clean package，得到jar包，
2、修改MF文件，添加下面配置：
Class-Path: javassist-3.25.0-GA.jar
Premain-Class: com.springframework.learn.service.Premain

3、把字节码jar包拷到同一文件夹下，jar包名字要与pom一致 javassist-3.25.0-GA.jar

4、执行：

java -javaagent:spring-java-aspectj-agent6-1.0-SNAPSHOT.jar -cp spring-java-aspectj-agent6-1.0-SNAPSHOT.jar com.springframework.learn.TestMainJar

后记：
经过优化之后，只用执行clean package，然后执行第四步就好了