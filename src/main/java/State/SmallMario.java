package State;

public class SmallMario implements IMario {
    private static final SmallMario instance = new SmallMario();

    private SmallMario() {
    }

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void meetMonster(MarioStateMachine2 stateMachine) {
        // do nothing...
    }

    @Override
    public void obtainFireFlower(MarioStateMachine2 stateMachine) {
        System.out.println("------获得火焰------");
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void obtainCape(MarioStateMachine2 stateMachine) {
        System.out.println("------获得斗篷-----");
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainMushRoom(MarioStateMachine2 stateMachine) {
        System.out.println("------吃了蘑菇-----");
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }


}
