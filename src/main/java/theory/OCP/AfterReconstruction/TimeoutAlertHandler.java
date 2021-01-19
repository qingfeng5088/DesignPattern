package theory.OCP.AfterReconstruction;

import theory.OCP.BeforeReconstruction.AlertRule;
import theory.OCP.BeforeReconstruction.Notfication;
import theory.OCP.BeforeReconstruction.NotificationEmergencyLevel;

public class TimeoutAlertHandler extends  AlertHandler{

    public TimeoutAlertHandler(AlertRule rule, Notfication notfication) {
        super(rule, notfication);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getTimeoutCount() /apiStatInfo.getDurationOfSeconds();
        if(tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutCount()){
            notfication.notify(NotificationEmergencyLevel.URGENCY, "现在的每秒超时次数:" + tps + " 超过设定值:" + rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutCount());
        }
    }
}
