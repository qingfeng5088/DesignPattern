package State;

public class Test02 {
    public static void main(String[] args) {
        MarioStateMachine2 stateMachine = new MarioStateMachine2();
        SmallMario smallMario = SmallMario.getInstance();
        smallMario.obtainCape(stateMachine);

        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());


        smallMario.obtainFireFlower(stateMachine);
        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());

        smallMario.obtainMushRoom(stateMachine);
        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());

        FireMario fireMario = FireMario.getInstance();
        fireMario.meetMonster(stateMachine);
        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());

        CapeMario capeMario = CapeMario.getInstance();
        capeMario.meetMonster(stateMachine);
        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());

        SuperMario superMario = SuperMario.getInstance();
        superMario.obtainFireFlower(stateMachine);
        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());

        superMario.meetMonster(stateMachine);
        System.out.println(stateMachine.getCurrentState().getName().getName());
        System.out.println(stateMachine.getScore());

    }
}
