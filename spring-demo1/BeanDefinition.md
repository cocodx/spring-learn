bean是一個對象，有名字，有class類型，有scope（單例，prototype），有role（屬於應用的bean，還是spring框架的bean），有是否延遲初始化（lazy-init），有它依賴的其他的bean，如果這個bean
，不好造，不能直接反射生成，可能還有個工廠方法和工廠bean，反正挺多的。

那是不是每個bean都是這樣的，還真是這樣的。
BeanDefinition就是每個bean的模板，最近寫了年終總結，hr小姐姐給我們發了模板，上面姓名啊，部門啊，職位啊，述職的基本格式啊，都是固定的，我們只要拿來，填上自己的信息就行了，那我們是不是可以抽象一下，
搞個class啊，比如下面的格式：
```
public class SpringDefinition{
  //bean class名稱
  String beanClassName;
  //工廠bean的名稱
  String factoryBeanName;
  //工廠方法的名稱
  String factoryMethodName;
  //singleton和prototype
  String scope;
  //是否延遲初始化
  boolean isLazyInit;
  //依賴的bean
  String[] dependsOn;
  //bean的角色
  int role;
  //是否為主候選的bean
  boolean primary;
}
```
實話説，是可以的，一些簡單的，輕量級ioc就是這麽玩的，但是spring作爲優秀代碼的代表，肯定不能這麽low，接口的抽象性要的多，方便我們替換的不同的實現，該用接口來
抽象，肯定要抽象為接口。
```
 * A BeanDefinition describes a bean instance, which has property values,
 * constructor argument values, and further information supplied by
 * concrete implementations.
 *
 * <p>This is just a minimal interface: The main intention is to allow a
 * {@link BeanFactoryPostProcessor} to introspect and modify property values
 * and other bean metadata.
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 19.03.2004
 ```
 這裏說的是，bean definition描述一個bean實例的各種屬性，尤其聲明了這是一個最小化接口，主要目的是允許bean factory後置處理器，對bean property和
 其他元數據進行修改，而且2004的接口，可想而知，是這麽多核心的api。
 ```
 public interface BeanDefinition extends AttributeAccessor,BeanMetadataElement{
  String getParentName();
  void setParentName(String parentName);
  String getBeanClassName();
  void setBeanClassName(String beanClassName);
  String getFactoryBeanName();
  void setFactoryBeanName(String factoryBeanName);
  String scope;
  void setScope(String scope);
  boolean isLazyInit();
  void setLazyInit(boolean lazyInit);
  String[] getDependsOn();
  void setDependsOn(String[] dependsOn);
  boolean isAutowireCandidate();
  void setAutowireCandidate(boolean autowireCandidate);
  boolean isPrimary();
  void setPrimary(boolean primary);
  ConstructorArgumentValues getConstructorArgumentValues();
  MutablePropertyValues getPropertyValues();
  boolean isSingleton();
  boolean osPrototype();
  boolean isAbstract();
  int getRole();
  String getDescription();
  String getResourceDescription();
  BeanDefinition getOrigintingBeanDefinition(); 
 }
  ```
  大家仔細看看，是不是其實和我們定義的class差不多呢，主要都是一些set、get方法。裏面的字段，下一個md，仔細吵吵，會結合一些融合貫通的地方。
  ###BeanDefinition接口的實現有哪些
  可以看到，這裏有兩個，標紅的，因爲他們特殊，特殊在他們不屬於spring-beans包，而是在spring-context包裏。后邊遇到了我們再bibi
  可以看這個接口的繼承圖：
  ![image](https://user-images.githubusercontent.com/97614802/155446523-e0bc5576-3a15-4cb9-8082-7a51dfbc18fd.png)

 ### 可以獲取注解信息的子接口AnnotatedBeanDefinition
 我們可以看到，BeanDefinition有一個子接口，是AnnotatedBeanDefinition。這個接口定義如下：
 ```
 public interface AnnotatedBeanDefinition extends BeanDefinition {

	/**
	 * Obtain the annotation metadata (as well as basic class metadata)
	 * for this bean definition's bean class.
	 * @return the annotation metadata object (never {@code null})
	 */
	AnnotationMetadata getMetadata();

}
  ```
可以想一想有什麽用，這個接口能獲取到bean definition中對應bean class上標注的注解元數據。
比如下面的controller實例：
![image](https://user-images.githubusercontent.com/97614802/155446922-b9b1a41d-a148-43a1-bdac-36869dbe1cea.png)

那這個AnnotatedBeanDefinition就能獲取到controller中的value字段  
我這裏也寫了一個簡答的例子，如下：

  AbstractBeanDefinition充当了基本实现，基本上，该实现的方法都实现了，除了一个CloneBeanDefinition()
   
   GenericBeanDefinition，感觉很重要，我们看看  
   AnnotatedGenericBeanDefinition，多了获取BeanClass的注解的功能。  
   ScannedGenericBeanDefinition位于spring-context，使用asm  
   AnnotatedGenericBeanDefinition，位于spring-beans，使用反射  
   
  
  
  
  
