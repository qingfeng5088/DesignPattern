package Bridge;

public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessageImpl impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "加急:" + message;
        super.sendMessage(message, toUser);
    }

    /**
     * 扩展自己的功能
     * @param messageId
     * @return
     */
    public Object watch(String messageId) {
        return null;
    }
}
