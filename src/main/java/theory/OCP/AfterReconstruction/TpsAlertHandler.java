package theory.OCP.AfterReconstruction;

import theory.OCP.BeforeReconstruction.AlertRule;
import theory.OCP.BeforeReconstruction.Notfication;
import theory.OCP.BeforeReconstruction.NotificationEmergencyLevel;

public class TpsAlertHandler extends  AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notfication notfication) {
        super(rule, notfication);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getReqestCount() /apiStatInfo.getDurationOfSeconds();
        if(tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()){
            notfication.notify(NotificationEmergencyLevel.URGENCY, "现在的TPS:" + tps + " 超过设定值:" + rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps());
        }
    }
}