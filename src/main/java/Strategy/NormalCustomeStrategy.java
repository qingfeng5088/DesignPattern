package Strategy;

public class NormalCustomeStrategy implements IStrategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于新客户或普通客户，没有折扣");
        return goodsPrice;
    }
}
