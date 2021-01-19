package theory.OCP;

import theory.OCP.BeforeReconstruction.Alert;
import theory.OCP.BeforeReconstruction.AlertRule;
import theory.OCP.BeforeReconstruction.Notfication;

public class Test {

    public static void main(String[] args) {

        AlertRule alertRule = new AlertRule();
        alertRule.addAlertRule("getUserInfo", 60, 10, 20);
        alertRule.addAlertRule("getGoodsInfo", 60, 20, 20);

        Notfication notfication = new Notfication();
        Alert alert = new Alert(alertRule, notfication);

        alert.check("getUserInfo", 160, 13L, 2L);
        alert.check("getGoodsInfo", 160, 13L, 2L);
    }
}
