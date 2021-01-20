package ProxyDP;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserInfoCollector userInfoCollector = new UserInfoCollector();
        Class<?>[] interfaces = userInfoCollector.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(userInfoCollector);
        IUserInfo uc = (IUserInfo)Proxy.newProxyInstance(userInfoCollector.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
        System.out.println(uc.getUserNameById("2"));
        System.out.println(uc.getAge("3"));
    }
}
