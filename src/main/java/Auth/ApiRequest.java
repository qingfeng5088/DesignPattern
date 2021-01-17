package Auth;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        String[] urlParams = url.split("\\?");
        String baseUrl = urlParams[0];

        Map<String, String> map = new HashMap<>();
        for (String s : urlParams[1].split("&")) {
            String[] paras = s.split("=");
            map.put(paras[0], paras[1]);
        }

        return new ApiRequest(baseUrl, map.get("token"), map.get("appid"), Long.parseLong(map.get("ts")));
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
