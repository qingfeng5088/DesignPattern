package Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类
 * 利用Java的静态内部类实现
 * 能做到延迟加载
 *
 * 创建过程的线程安全性有JVM来保证，
 * 这种方法既保证了线程安全，又能做到延迟加载
 *
 * 实现简单
 *
 */
public class IdGenerator3 {
    private final AtomicLong id = new AtomicLong(0);
    private static IdGenerator3 instance;

    private IdGenerator3() {

    }

    private static class SingletonHolder {
        private static final IdGenerator3 instance = new IdGenerator3();
    }

    public static  IdGenerator3 getInstance(){
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
