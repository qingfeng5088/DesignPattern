package Interface;

public class Test implements Itest {
    @Override
    public String say() {
        return null;
    }

    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(Itest.CONT);
    }
}
