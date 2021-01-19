package theory.OCP.AfterReconstruction;

import java.util.ArrayList;
import java.util.List;

public class Alert {
    private final List<AlertHandler> alertHandlerList = new ArrayList<>();

    public void addAlertHandle(AlertHandler alertHandler) {
        this.alertHandlerList.add(alertHandler);
    }

    public void check( ApiStatInfo apiStatInfo){
        System.out.println("现在调用接口:" + apiStatInfo.getApi());
        for (AlertHandler alertHandler : alertHandlerList) {
            alertHandler.check(apiStatInfo);
        }
    }
}
