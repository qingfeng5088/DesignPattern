package Visitor.DoubleDispatch;

public class SingleDispatch {
    public  void polymorphismFunction(Parent p) {
        p.f();
    }

    public  void overloadFunction(Parent p) {
        System.out.println("我是重载方法（Parent p）");
    }

    public  void overloadFunction(Child c) {
        System.out.println("我是子类重载方法（Parent c）");
    }
}
