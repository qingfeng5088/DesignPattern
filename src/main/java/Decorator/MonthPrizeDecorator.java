package Decorator;

import java.util.Date;

public class MonthPrizeDecorator extends Decorator {
    public MonthPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double prize = mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user + "当月业务奖金:" + prize);
        return money + prize;
    }
}
