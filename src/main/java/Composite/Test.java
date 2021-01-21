package Composite;

public class Test {
    public static void main(String[] args) {
        Component root = new Composite("服装");
        Component c1 = new Composite("男装");
        Component c2 = new Composite("女装");
        Component c3 = new Composite("童装");
        Component c4 = new Composite("男童装");
        Component c5 = new Composite("女童装");
        Component leaf1 = new Leaf("衬衣");
        Component leaf2 = new Leaf("夹克");
        Component leaf3 = new Leaf("裙子");
        Component leaf4 = new Leaf("套装");

        root.addChild(c1);
        root.addChild(c2);
        root.addChild(c3);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);


        c3.addChild(c4);
        c3.addChild(c5);

        Component leaf5 = new Leaf("5岁男童装");
        Component leaf6 = new Leaf("7岁男童装");
        c4.addChild(leaf5);
        c4.addChild(leaf6);

        root.printStruct("");
    }
}
