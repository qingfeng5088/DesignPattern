package Decorator;

import java.util.Date;

public class GroupPrizeDecorator extends Decorator {
    public GroupPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        double prize1 = mapMonthSaleMoney.values().stream().reduce(0.0, Double::sum) * 0.01;
        double prize2 = mapMonthSaleMoney.values().stream().mapToDouble(x -> x).sum() * 0.01;
        System.out.println(user + "当月团队业务奖金:" + prize2);
        return money + prize2;
    }
}
