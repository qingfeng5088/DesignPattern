package Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举 实现单例模式
 * <p>
 * 通过Java枚举类型本事的特性，保证实例创建的线程安全和实例的唯一性。
 */
public enum IdGenerator4 {
    INSTANCE;
    private final AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
