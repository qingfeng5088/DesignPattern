package theory.OCP.AfterReconstruction;

import theory.OCP.BeforeReconstruction.AlertRule;
import theory.OCP.BeforeReconstruction.Notfication;

public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notfication notfication;
    public AlertHandler(AlertRule rule,Notfication notfication){
        this.rule = rule;
        this.notfication = notfication;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
