package Factory.DI;

public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("----------qiu First DI-------------");
        System.out.println("Hello world!");
        System.out.println(redisCounter);
    }
}
