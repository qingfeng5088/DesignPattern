package Singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 进程唯一单例
 */
public class IdGenerator_processSafe {
    private final AtomicLong id = new AtomicLong(0);
    private static IdGenerator_processSafe instance;
    //private static SharedObjectStorage
   // private  static DistributedLock lock;

    private static final ConcurrentHashMap<Long, IdGenerator_processSafe> instances = new ConcurrentHashMap<>();

    private IdGenerator_processSafe() {

    }

    public static IdGenerator_processSafe getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator_processSafe());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
