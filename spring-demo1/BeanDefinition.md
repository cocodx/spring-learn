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
