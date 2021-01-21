package Decorator;

import java.util.Date;

public class SumPrizeDecorator extends Decorator {
    public SumPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double prize = 1000000 * 0.001;
        System.out.println(user + "累计奖金:" + prize);
        return money + prize;
    }
}
