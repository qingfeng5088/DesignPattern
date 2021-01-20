package Bridge;

public class MessageMobile implements IMessageImpl {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用手机短信，发送消息[" + message + "]给:" + toUser);
    }
}
