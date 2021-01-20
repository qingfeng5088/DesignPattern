package Bridge;

public class Test {
    public static void main(String[] args) {
        IMessageImpl impl1 = new MessageSMS();
        IMessageImpl impl2 = new MessageEmail();
        IMessageImpl impl3 = new MessageMobile();
        AbstractMessage m = new CommonMessage(impl1);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
        m = new UrgencyMessage(impl1);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
        m = new SpectialMessage(impl1);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");

        m = new CommonMessage(impl2);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
        m = new UrgencyMessage(impl2);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
        m = new SpectialMessage(impl2);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");

        m = new CommonMessage(impl3);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
        m = new UrgencyMessage(impl3);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
        m = new SpectialMessage(impl3);
        m.sendMessage("发送消息重复，速来调查！", "qiuchunbo");
    }
}
