package ProxyDP.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-----在这里可以添加你的控制代码-----");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("-----执行完方法后，可以在这里添加你的代码-----");
        return object;
    }
}
