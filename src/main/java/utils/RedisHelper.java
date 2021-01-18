package utils;

import redis.clients.jedis.Jedis;

public class RedisHelper {
    private static Jedis jedis;

    public static Jedis getRedis() {
        if (jedis == null) {
            jedis = new Jedis("127.0.0.1");
        }

        return jedis;
    }
}
