package OCP.BeforeReconstruction;

import java.util.HashMap;
import java.util.Map;

public class AlertRule {
    private int maxTps = 0;
    private int maxErrorCount = 0;
    private int maxTimeoutCount = 0;
    private final Map<String, AlertRule> ruleMap = new HashMap<>();

    public AlertRule() {
    }

    public AlertRule(int maxTps, int maxErrorCount, int maxTimeoutCount) {
        this.maxTps = maxTps;
        this.maxErrorCount = maxErrorCount;
        this.maxTimeoutCount = maxTimeoutCount;
    }

    public void addAlertRule(String api, int maxTps, int maxErrorCount, int maxTimeoutCount) {
        ruleMap.put(api, new AlertRule(maxTps, maxErrorCount,maxTimeoutCount));
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

    public int getMaxTimeoutCount() {
        return maxTimeoutCount;
    }
}
