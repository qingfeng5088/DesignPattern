package Strategy;

public class Test {
    public static void main(String[] args) {
        IStrategy strategy = new LargeCustomeStrategy();

        Price ctx = new Price(strategy);
        System.out.println(ctx.quote(1000));

        strategy = new OldCustomeStrategy();
        ctx = new Price(strategy);
        System.out.println(ctx.quote(1000));

        strategy = new NormalCustomeStrategy();
        ctx = new Price(strategy);
        System.out.println(ctx.quote(1000));
    }
}
