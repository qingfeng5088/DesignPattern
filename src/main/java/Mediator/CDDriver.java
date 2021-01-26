package Mediator;

public class CDDriver extends  Colleague {
    private String data = "";
    public CDDriver(IMediator mediator) {
        super(mediator);
    }

    public String getData(){
        return this.data;
    }

    public void readCD(){
        this.data = "设计模式, 值得好好研究一下！";
        // 通知主板自己发生了变化
        this.getMediator().changed(this);
    }
}
