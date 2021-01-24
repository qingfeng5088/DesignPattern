package State;

public class Test {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        System.out.println(mario.getCurrentState().getName());
        System.out.println(mario.getScore());


        mario.obtainCape();
        System.out.println(mario.getCurrentState().getName());
        System.out.println(mario.getScore());

        mario.obtainMushRoom();
        System.out.println(mario.getCurrentState().getName());
        System.out.println(mario.getScore());

        mario.meetMonster();
        System.out.println(mario.getCurrentState().getName());
        System.out.println(mario.getScore());

        mario.obtainFireFlower();
        System.out.println(mario.getCurrentState().getName());
        System.out.println(mario.getScore());

        mario.obtainMushRoom();
        System.out.println(mario.getCurrentState().getName());
        System.out.println(mario.getScore());
    }
}
