package Strategy;

public class Price {
    private IStrategy strategy = null;

    public Price(IStrategy strategy) {
        this.strategy = strategy;
    }

    public double quote(double goodsPrice) {
        return  this.strategy.calcPrice(goodsPrice);
    }
}
