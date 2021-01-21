package Decorator;

import java.util.Date;

public abstract class Decorator extends  Component{
    protected  Component c;

    public Decorator(Component c) {
        this.c = c;
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        // 调用组件对象的方法
        return this.c.calcPrize(user,begin,end);
    }
}
