package ProxyDP;

import java.util.HashMap;
import java.util.Map;

public class UserInfoCollector implements IUserInfo {
    private final Map<String, String> map = new HashMap<>();

    {
        map.put("1", "邱羽彤");
        map.put("2", "琳琳");
        map.put("3", "邱春波");
    }

    public String getUserNameById(String id) {
        return map.get(id);
    }

    @Override
    public int getAge(String id) {
        if ("1".equals(id)) {
            return 5;
        }

        if ("2".equals(id)) {
            return 35;
        }

        return 38;
    }

    @Override
    public String toString() {
        return "UserInfoCollector{" +
                "map=" + map +
                '}';
    }
}
