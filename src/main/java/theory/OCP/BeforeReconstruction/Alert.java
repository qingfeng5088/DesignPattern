package theory.OCP.BeforeReconstruction;

/**
 * API  接口监控警告代码
 * <p>
 * Open Closed Principle
 * software entities should be open for extension,
 * but closed for modification
 * 堆扩展开放，对修改关闭
 * <p>
 * 重构前
 */
public class Alert {
    private AlertRule rule;
    private Notfication notfication;

    public Alert(AlertRule rule, Notfication notfication) {
        this.rule = rule;
        this.notfication = notfication;
    }

    public void check(String api, long requestCont, long errorCount, long durationOfSeconds) {
        long tps = requestCont / durationOfSeconds;

        System.out.println("现在调用接口:" + api);
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notfication.notify(NotificationEmergencyLevel.URGENCY, "现在的TPS:" + tps + " 超过设定值:" + rule.getMatchedRule(api).getMaxTps());
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notfication.notify(NotificationEmergencyLevel.SEVERE, "现在请求错误数:" + errorCount + " 超过设定值:" + rule.getMatchedRule(api).getMaxErrorCount());
        }
    }

}
