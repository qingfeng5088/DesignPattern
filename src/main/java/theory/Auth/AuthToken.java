package theory.Auth;

import utils.DesUtil;

import java.util.Map;

/**
 * 并不是所有出现的名词都被定义为类的属性，比如URL，AppID，密码，时间戳等
 * 这几个名词，我们把它作为方法的参数。
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000;
    private String token;
    private long creatTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long creatTime) {
        this.token = token;
        this.creatTime = creatTime;
    }

    public static AuthToken generate(String baseUrl, long creatTime, Map<String, String> params) throws Exception {
        String appid = params.get("appid");
        String password = params.get("password");
        String timestamp = params.get("ts");

        String tokenStr = baseUrl + appid + password + timestamp;
        String token = DesUtil.encode(tokenStr, password);

        return new AuthToken(token, creatTime);
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return (System.currentTimeMillis() - creatTime) > expiredTimeInterval;
    }

    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.getToken());
    }
}
