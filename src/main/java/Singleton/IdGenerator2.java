package Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检测
 * 解决了懒汉式并发度低的问题
 */
public class IdGenerator2 {
    private final AtomicLong id = new AtomicLong(0);
    private static IdGenerator2 instance;

    private IdGenerator2() {

    }

    public static IdGenerator2 getInstance() {
        //双重检测
        if (instance == null) {
            synchronized (IdGenerator2.class){
                if (instance == null) {
                    instance = new IdGenerator2();
                }
            }
        }

        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
