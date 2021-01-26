package Command;

public class GigaMainBoard implements IMainBoardApi {
    @Override
    public void open() {
        System.out.println("技嘉主板正在开机，请稍后...");
        System.out.println("接通电源......");
        System.out.println("检查设备......");
        System.out.println("装载系统......");
        System.out.println("机器正常运转起来了......");
        System.out.println("机器已正常开机，请使用......");
    }

    @Override
    public void restart() {
        System.out.println("技嘉主板正在重启，请稍后...");
        System.out.println("检查设备......");
        System.out.println("装载系统......");
        System.out.println("机器重新启动起来了......");
        System.out.println("机器已正常开机，请使用......");
    }
}
