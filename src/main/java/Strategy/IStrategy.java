package Strategy;

/**
 * 策略模式：
 * 定义一系列的算法，把他们一个个封装起来，并且使它们可相互替代。
 * 本模式使得算法可独立于使用它的客户而变化。
 */
public interface IStrategy {
    public double calcPrice(double goodsPrice);
}
