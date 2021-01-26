package Mediator;
public class VideoCard  extends  Colleague{
    public VideoCard(IMediator mediator) {
        super(mediator);
    }

    public void showData(String data) {
        System.out.println("您正在观看的是:"+data);
    }
}
