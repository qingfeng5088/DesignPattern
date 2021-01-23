package Flyweight;

public class Test02 {

    public static void main(String[] args) {
        Integer i1 = 28;
        Integer i2 = 28;

        Integer i5 = Integer.valueOf("28");
        Integer i6 = Integer.parseInt("28");
        Integer i7 = new Integer(28);

        System.out.println(i1 == i2);
        System.out.println(i1 == i5);
        System.out.println(i1 == i6);
        System.out.println(i1 == i7);


        Integer i3 = 129;
        Integer i4 = 129;

        System.out.println(i3 == i4);


        String s1 = "邱羽彤";
        String s2 = "邱羽彤"+"";
        String s3 = new String("邱羽彤");
        String s4 = String.valueOf("邱羽彤");

        System.out.println("-------------字符串比较----------");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }
}
