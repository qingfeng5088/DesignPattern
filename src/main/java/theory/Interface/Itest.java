package theory.Interface;

public interface Itest {
    // 字段默认都是静态的
    int CONT = 100;

    String say();

    // Java8 开始有默认实现的方法了
    default String say2() {
        return "say some thing!";
    }

}
