package OCP;

import java.util.HashMap;
import java.util.Map;

public class AlertRule {
    private final int maxTps;
    private final int maxErrorCount;

    private final Map<String, AlertRule> ruleMap = new HashMap<>();

    public AlertRule(int maxTps, int maxErrorCount) {
        this.maxTps = maxTps;
        this.maxErrorCount = maxErrorCount;
    }

    public void addAlertRule(String api, int maxTps, int maxErrorCount) {
        ruleMap.put(api, new AlertRule(maxTps, maxErrorCount));
    }

    public AlertRule getMatchedRule(String api) {
        return ruleMap.get(api);
    }

    public int getMaxTps() {
        return maxTps;
    }

    public int getMaxErrorCount() {
        return maxErrorCount;
    }
}
