package Visitor.DoubleDispatch;

public class Test {
    public static void main(String[] args) {
        SingleDispatch demo = new SingleDispatch();
        Parent p = new Child();
        demo.polymorphismFunction(p);
        demo.overloadFunction(p);
    }
}
