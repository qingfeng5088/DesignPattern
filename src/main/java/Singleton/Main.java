package Singleton;

/**
 * 1：为什么要使用单例
 * 2：单例存在哪些问题
 * 3：单例与静态类的区别
 * 4: 有何替代的解决方案
 */
public interface Main {
    //1：加锁
    // 对象级别的锁 synchronized（this）
    // 类级别的锁  synchronized（Main.class）
    //2：分布式锁
    //3：并发队列
}
