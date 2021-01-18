package OCP.BeforeReconstruction;

public class Notfication {
    public void notify(NotificationEmergencyLevel level, String message) {
        System.out.println("警告级别:" + level + " 警告信息:" + message);
    }
}
