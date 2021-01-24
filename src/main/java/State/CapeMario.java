package State;

public class CapeMario implements IMario {
    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void meetMonster(MarioStateMachine2 stateMachine) {
        System.out.println("------遇到怪物-----");
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine2 stateMachine) {
        // do nothing
    }

    @Override
    public void obtainCape(MarioStateMachine2 stateMachine) {
        // do nothing
    }

    @Override
    public void obtainMushRoom(MarioStateMachine2 stateMachine) {
        // do nothing
    }


}
