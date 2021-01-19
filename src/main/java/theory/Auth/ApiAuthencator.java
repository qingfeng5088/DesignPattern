package theory.Auth;

public interface ApiAuthencator {
    void auth(String url) throws Exception;
    void auth(ApiRequest apiRequest) throws Exception;
}
