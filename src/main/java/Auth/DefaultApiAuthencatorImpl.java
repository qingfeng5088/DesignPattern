package Auth;

import java.util.HashMap;
import java.util.Map;

public class DefaultApiAuthencatorImpl implements ApiAuthencator {
    private CreadentialStorage creadentialStorage;

    public DefaultApiAuthencatorImpl(CreadentialStorage creadentialStorage) {
        this.creadentialStorage = creadentialStorage;
    }

    @Override
    public void auth(String url) throws Exception {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) throws Exception {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String baseUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }

        String password = creadentialStorage.getPasswordByAppId(appId);
        Map<String, String> map = new HashMap<>();
        map.put("appid", appId);
        map.put("password", password);
        map.put("ts", timestamp+"");

        AuthToken serverAuthToken = AuthToken.generate(baseUrl, timestamp, map);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verication failed.");
        }

        System.out.println("-------------鉴权成功，可以继续访问！-----------");
    }
}
