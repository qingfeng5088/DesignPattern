package Observer_api;

public class Test {
    public static void main(String[] args) {

        Reader zhangsan = new Reader();
        zhangsan.setName("张三");

        Reader lisi = new Reader();
        lisi.setName("李四");

        Reader wangwu = new Reader();
        wangwu.setName("王五");

        Reader zhaoliu = new Reader();
        zhaoliu.setName("赵六");

        NewsPaper newsPaper = new NewsPaper();
        newsPaper.attach(zhangsan);
        newsPaper.attach(lisi);


        newsPaper.attach(wangwu);
        newsPaper.attach(zhaoliu);

        newsPaper.notifyObservers("本期内容是观察者模式！");
    }
}
