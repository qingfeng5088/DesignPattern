package practice.cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * https://www.jianshu.com/p/38bd5f1cf2f2
 * 什么时候用
 * 愿意消耗一些内存空间来提升速度
 * 预料到某些键会被多次查询
 * 缓存中存放的数据总量不会超出内存容量
 * 怎么用
 * 设置缓存容量
 * 设置超时时间
 * 提供移除监听器
 * 提供缓存加载器
 * 构建缓存
 */
public class CacheDemo {
    private static final Logger logger = Logger.getLogger(CacheDemo.class.getName());

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .initialCapacity(1)
                .maximumSize(3)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .build();

        cache.put("k1", "qiuyutong");
        cache.put("k2", "qiuchunbo");
        cache.put("k3", "linlin");

        System.out.println(cache.getIfPresent("k1"));
        System.out.println(cache.getIfPresent("k2"));
        System.out.println(cache.getIfPresent("k3"));
        System.out.println(cache.size());
        System.out.println(cache.stats());


        CacheLoader<String, String> loader = new CacheLoader<>() {
            public String load(String key) throws Exception {
                Thread.sleep(1000);
                if ("key".equals(key)) return null;
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        RemovalListener<String, String> removalListener = removal -> System.out.println("[" + removal.getKey() + ":" + removal.getValue() + "] is evicted!");

        LoadingCache<String, String> testCache = CacheBuilder.newBuilder()
                .maximumSize(7)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(removalListener)
                .build(loader);

        for (int i = 0; i < 10; i++) {
            String key = "key" + i;
            String value = "value" + i;
            testCache.put(key, value);
            System.out.println("[" + key + ":" + value + "] is put into cache!");
        }

        System.out.println(testCache.getIfPresent("key6"));

        try {
            System.out.println(testCache.get("key"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
