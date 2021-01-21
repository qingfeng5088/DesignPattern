package Decorator;

import java.util.Date;

public class ConcreteComponet extends Component {

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        // 只是一个默认的实现，默认没有奖金
        return 0;
    }
}
