package State;

public enum State {
    SMALL("小马里奥",0),
    SUPER("超级马里奥",1),
    FIRE("火焰马里奥",2),
    CAPE("斗篷马里奥",3);

    private final String name;
    private final int index;

    State(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static void main(String[] args) {
        System.out.println(State.FIRE.getName());
        System.out.println(State.FIRE.getIndex());
    }
}
