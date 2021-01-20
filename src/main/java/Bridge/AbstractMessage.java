package Bridge;

/**
 * 抽象的消息对象
 *
 * 定义：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 *
 * 桥接就是给被分离的抽象部分和实现部分搭桥
 */
public class AbstractMessage {
    // 让抽象部分拥有实现部分的接口对象，就桥接上了。
    protected IMessageImpl impl;

    public AbstractMessage(IMessageImpl impl) {
        this.impl = impl;
    }

    public void sendMessage(String message,String toUser) {
        this.impl.send(message,toUser);
    }
}
