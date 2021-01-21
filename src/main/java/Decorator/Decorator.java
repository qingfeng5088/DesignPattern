package Decorator;

import java.util.Date;

/**
 * 1：装饰器类和原始类继承同样的父类，这样就可以对原始类嵌套多个装饰器类
 * 2：装饰器类是对功能的增强，这也是装饰器模式应用场景的一个重要特点
 * 3：通过组合来代替继承
 */
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
