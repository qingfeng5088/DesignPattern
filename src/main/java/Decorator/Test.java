package Decorator;

public class Test {

    public static void main(String[] args) {
        Component c1 = new ConcreteComponet();

        Decorator d1 = new MonthPrizeDecorator(c1);
        Decorator d2 = new SumPrizeDecorator(d1);
        System.out.println();

        double qyt = d2.calcPrize("邱羽彤", null, null);
        System.out.println("------邱羽彤当月应得奖金:" + qyt);

        System.out.println();

        double linlin = d2.calcPrize("林琳", null, null);
        System.out.println("------林琳当月应得奖金:" + linlin);

        System.out.println();
        double lizhongxia = d2.calcPrize("李中霞", null, null);
        System.out.println("------林琳当月应得奖金:" + lizhongxia);


        System.out.println();
        Decorator d3 = new GroupPrizeDecorator(d2);
        double qiuchunbo = d3.calcPrize("邱春波",null,null);
        System.out.println("------邱春波当月应得奖金:" + qiuchunbo);
    }
}
