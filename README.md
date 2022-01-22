# spring-learn
记录学习spring源码的一个操作项目

## 子项目
### spring-demo1
介绍：对AnnotatedBeanDefinition的使用，注册同名beanName的beanDefinition

### spring-demo2
介绍：手动注册BeanDefinition，通过构造函数注入，通过set()方法注入

### spring-demo3
介绍：自定义applicationContext，从json文件读取beanDefinition

### spring-demo4
介绍：PropertyBeanDefinitionReader，从properties文件中读取bean definition

### spring-demo5
|namespace|element|
|:-|:-|
|util|constant、property-path、list、set、map、properties|  
|context|property-placeholder、property-override、annotation-config、component-scan、load-time-weaver、spring-configured、mbean-export、mbean-server| 
|beans|import、alias、bean|
|task|annotation-driven、scheduler、scheduled-tasks、executor|
|cache|advice、annotation-driven|
|aop|config、scoped-proxy、aspectj-autoproxy|

介绍：从xml文件中拿到什么，对xml的使用  
TestUtilListElement:对<util:list>标签使用  
TestProperties:对<util:properties>标签使用  
TestConstant:对<util:constant>标签使用  
TestPropertyPlaceHolder:对<context::property-placeholder>标签使用  
context:annotation-config：对<context:annotation-config>标签使用