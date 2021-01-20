package Bridge;

public class CommonMessage extends AbstractMessage {
    public CommonMessage(IMessageImpl impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
