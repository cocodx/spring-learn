罗列一下BeanDefinition中重要的属性：  
1、beanName
虽然这个接口里没这个东西，但这个贼重要，默认规则是：beanClassName，SpringBoot里面是按驼峰形式转换后的名字。  
这里面有个重要，DefaultListableBeanFactory中，采用了下面的字段来存bean和对应的BeanDefinition。 
```
private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>(64);  
```
这里说了，key是beanName  
那大家想过没，我如果同一个上下文中，有两个beanName相同的BeanDefinition会怎么样呢？ 
在Feign项目启动的时候，启动报错了，就是因为beanName重复了  
```
spring:
  main:
    allow-bean-definition-overriding: true
```
这个配置，在spring之前的版本里，默认是true，结果在spring boot里，默认改为false了。  
我这边通过下面的代码测试了一下：
1、当这个配置为true时候，正常，为false的时候，报错。  

### scope
默认为singleton，在容器内只会有一个bean。prototype，每个getBean的时候都会new一个对象，这个一般不会再启动时区初始化，如果写的有问题的话，启动时不报错，
runtime的时候，报运行时异常。  
### parentBean
指定parentBean的名称，以前xml的时候可能会用，现在注解驱动了，基本很少用了。  
### beanClassName
核心属性，bean的class类型，这里说的是实际类型，而一般不是接口的名称。比如，我们的注解一般是加在class上的，而不是加在接口上，对吧，即使加在接口上，那肯定也是
动态代理技术，对吧，毕竟，bean是要以这个class的元数据来进行创建（一般通过反射）  
### factoryBeanName、factoryMethodName
如果本bean是通过其他工厂bean来创建，则这个两个字段为对应的工厂bean的名称，和对应的工厂方法名称。
