package Auth;

import utils.DesUtil;

public class Test {
    public static void main(String[] args) throws Exception {
        //-----------客户端准备 开始---------------------
        String baseUrl = "http://www.baidu.com/user";
        String appid = "qingfeng5088";
        String password = "qiuyutong521123";
        long timestamp = System.currentTimeMillis();
        String tokenStr = baseUrl + appid + password + timestamp;

        String token = DesUtil.encode(tokenStr, password);
        System.out.println(token);
        String url = baseUrl + "?appid=" + appid + "&token=" + token + "&ts=" + timestamp;


        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        System.out.println("baseUrl :" + apiRequest.getBaseUrl());
        System.out.println("appId:" + apiRequest.getAppId());
        System.out.println("token:" + apiRequest.getToken());
        System.out.println("timestamp:" + apiRequest.getTimestamp());
        //-----------客户端准备 结束---------------------


        //---------- 鉴权开始 --------------------------
        ApiAuthencator apiAuthencator = new DefaultApiAuthencatorImpl(x -> {
            if (x.equals(appid)) return password;
            return x;
        });

        apiAuthencator.auth(url);
    }
}
