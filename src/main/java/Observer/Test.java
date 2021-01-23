package Observer;

public class Test {
    public static void main(String[] args) {
        NewsPaper subject = new NewsPaper();

        Reader zhangsan = new Reader();
        zhangsan.setName("张三");

        Reader lisi = new Reader();
        lisi.setName("李四");

        Reader wangwu = new Reader();
        wangwu.setName("王五");

        Reader  zhaoliu= new Reader();
        zhaoliu.setName("赵六");

        subject.attach(zhangsan);
        subject.attach(lisi);
        subject.attach(wangwu);
        subject.attach(zhaoliu);

        subject.setContent("本期内容是观察者模式！");
    }
}
