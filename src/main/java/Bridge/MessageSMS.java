package Bridge;

public class MessageSMS implements IMessageImpl {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用站内短消息，发送消息[" + message + "]给:" + toUser);
    }
}
