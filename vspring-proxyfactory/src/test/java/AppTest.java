import com.springframework.learn.service.Perform;
import com.springframework.learn.service.Performer;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 7/2/2022 上午4:09
 */
@Slf4j
public class AppTest {


    /**
     * 在代理对象中，调用不在接口的方法
     *
     *
     * jdk动态代理的步骤，：
     * 1、生成动态代理的class，不像其他class文件，是编译就有的，这里是动态生成的
     * 2、加载第一步拿到的字节流，丢给jvm加载该class，拿到class对象
     * 3、根据第二步的class对象，反射生成动态代理对象
     *
     */
    @Test
    public void createJdkDynamicProxyManual() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object generateProxy = Proxy.newProxyInstance(classLoader, new Class[]{Perform.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy:"+proxy.getClass());
                return "hahahaha";
            }
        });
        Method eat = Perform.class.getMethod("eat");
        eat.setAccessible(true);
        eat.invoke(generateProxy,null);
    }

    public static class MyCustomInvocationHandler implements InvocationHandler{

        Performer performer;

        public MyCustomInvocationHandler(Performer performer) {
            this.performer = performer;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("我就是一个称职的代理");
            return method.invoke(performer,args);
        }
    }

    //正确的思路，就是在构造proxy的时候，把你需要的东西，都通过构造函数或setter，传递给invocationHandler。
    //然后再在invoke方法内使用这些东西，来完成你的逻辑
    @Test
    public void createJdkDynamicProxyManual1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Performer performer = new Performer();
        MyCustomInvocationHandler invocationHandler = new MyCustomInvocationHandler(performer);

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Object generateProxy = Proxy.newProxyInstance(loader,new Class[]{Perform.class},invocationHandler);

        ((Perform)generateProxy).sing();
    }

    //使用spring提供的ProxyFactory创建代理
    @Test
    public void createJdkDynamicProxy(){
        ProxyFactory proxyFactory = new ProxyFactory();
        Performer performer = new Performer();
        proxyFactory.setTarget(performer);
        proxyFactory.addInterface(Perform.class);

        Perform proxy = (Perform) proxyFactory.getProxy();
        System.out.println(String.format("proxy class:%s",proxy.getClass().getName()));
        proxy.sing();
        System.out.println(String.format("proxy :%s",proxy));
    }

    //创建代理的同时，织入切面
    @Test
    public void createJdkDynamicProxyWithAdvisor(){
        ProxyFactory proxyFactory = new ProxyFactory();
        Performer performer = new Performer();
        proxyFactory.setTarget(performer);
        proxyFactory.addInterface(Perform.class);

        //advisor几乎等于 切点+通知
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object result = invocation.proceed();
                System.out.println("男孩唱完歌之后要行礼");
                return result;
            }
        });

        //记录耗时
//        advisor.setAdvice(new PerformanceMonitorInterceptor ());

        proxyFactory.addAdvisor(advisor);

        Perform proxy = (Perform) proxyFactory.getProxy();
//        System.out.println(String.format("proxy class:%s",proxy.getClass().getName()));
        proxy.sing();
        log.debug("xxxxxxxxxxxx");
//        System.out.println(String.format("proxy :%s",proxy));
    }
}
