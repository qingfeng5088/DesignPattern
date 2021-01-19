package Singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程唯一单例
 */
public class IdGenerator_threadSafe {
    private final AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGenerator_threadSafe> instances = new ConcurrentHashMap<>();

    private IdGenerator_threadSafe() {

    }

    public static IdGenerator_threadSafe getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator_threadSafe());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
