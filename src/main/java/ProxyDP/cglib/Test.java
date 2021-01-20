package ProxyDP.cglib;

import ProxyDP.IUserInfo;
import ProxyDP.UserInfoCollector;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * CGLIB和Java动态代理的区别
 * Java动态代理只能够对接口进行代理，不能对普通的类进行代理（因为所有生成的代理类的父类为Proxy，Java类继承机制不允许多重继承）；CGLIB能够代理普通类；
 * Java动态代理使用Java原生的反射API进行操作，在生成类上比较高效；CGLIB使用ASM框架直接对字节码进行操作，在类的执行过程中比较高效
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\javaProxy");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserInfoCollector.class);
        enhancer.setCallback(new MyMethodInterceptor());

        UserInfoCollector uc = (UserInfoCollector) enhancer.create();
        System.out.println(uc.getUserNameById("1"));
        System.out.println(uc.getAge("1"));
    }
}
