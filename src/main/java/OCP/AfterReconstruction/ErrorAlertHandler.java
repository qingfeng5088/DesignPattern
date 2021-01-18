package OCP.AfterReconstruction;

import OCP.BeforeReconstruction.AlertRule;
import OCP.BeforeReconstruction.Notfication;
import OCP.BeforeReconstruction.NotificationEmergencyLevel;

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notfication notfication) {
        super(rule, notfication);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notfication.notify(NotificationEmergencyLevel.SEVERE, "现在请求错误数:" + apiStatInfo.getErrorCount() + " 超过设定值:" + rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount());
        }
    }
}
