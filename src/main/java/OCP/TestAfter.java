package OCP;

import OCP.AfterReconstruction.*;
import OCP.BeforeReconstruction.AlertRule;
import OCP.BeforeReconstruction.Notfication;

public class TestAfter {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo1 = new ApiStatInfo("getGoodsInfo", 135, 16, 52, 2);
        AlertRule alertRule = new AlertRule();
        alertRule.addAlertRule("getUserInfo", 60, 10, 25);
        alertRule.addAlertRule("getGoodsInfo", 60, 20, 23);

        Notfication notfication = new Notfication();
        Alert alert = new Alert();

        ErrorAlertHandler errorAlertHandler = new ErrorAlertHandler(alertRule, notfication);
        TpsAlertHandler tpsAlertHandler = new TpsAlertHandler(alertRule, notfication);
        TimeoutAlertHandler timeoutAlertHandler = new TimeoutAlertHandler(alertRule,notfication);
        alert.addAlertHandle(errorAlertHandler);
        alert.addAlertHandle(tpsAlertHandler);
        alert.addAlertHandle(timeoutAlertHandler);

        alert.check(apiStatInfo1);
    }
}
