package ProxyDP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private Object proxiedObject;

    public DynamicProxyHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------开始时间:" + System.currentTimeMillis());
        Object ret = method.invoke(proxiedObject, args);
        System.out.println("-------结束时间:" + System.currentTimeMillis());

        return ret;
    }
}
