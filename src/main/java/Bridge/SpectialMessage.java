package Bridge;

public class SpectialMessage extends AbstractMessage {
    public SpectialMessage(IMessageImpl impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "特急:" + message;
        super.sendMessage(message, toUser);
    }

    public void hurry(String messageId) {
        //执行催促的业务，发送催促的信息
    }


}
