package practice.Lambda;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("开始执行");
        });

        thread.start();
    }


}
