package Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * 缺点：
 * 1：方法加锁（synchronzed）
 * 频繁调用时，加锁，释放锁消耗资源，会导致性能瓶颈。
 */
public class IdGenerator1 {
    private final AtomicLong id = new AtomicLong(0);
    private  static IdGenerator1 instance;
    private IdGenerator1(){

    }

    public static synchronized IdGenerator1 getInstance() {
        if(instance == null) {
            instance = new IdGenerator1();
        }

        return  instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
