package Bridge;

/**
 * 实现发送消息的统一接口
 */
public interface IMessageImpl {
    void send(String message, String toUser);
}
