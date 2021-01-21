package Decorator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Component {
    public static Map<String,Double> mapMonthSaleMoney = new HashMap<>();

    static {
        mapMonthSaleMoney.put("邱羽彤",2800.0);
        mapMonthSaleMoney.put("李中霞",1600.0);
        mapMonthSaleMoney.put("林琳",12800.0);
        mapMonthSaleMoney.put("邱春波",32800.0);
    }

    /**
     * 计算某人在某段时间内的奖金
     * @param user
     * @param begin
     * @param end
     * @return
     */
    public abstract double calcPrize(String user, Date begin, Date end);
}
