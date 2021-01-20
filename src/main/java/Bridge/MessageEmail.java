package Bridge;

public class MessageEmail implements IMessageImpl {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用E-mail，发送消息[" + message + "]给:" + toUser);
    }
}
