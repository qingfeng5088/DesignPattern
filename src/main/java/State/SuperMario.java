package State;

public class SuperMario implements IMario {
    private static final SuperMario instance = new SuperMario();

    private SuperMario() {
    }

    public static SuperMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void meetMonster(MarioStateMachine2 stateMachine) {
        System.out.println("------遇到怪物-----");
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine2 stateMachine) {
        System.out.println("------获得火焰-----");
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void obtainCape(MarioStateMachine2 stateMachine) {
        System.out.println("------获得斗篷-----");
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainMushRoom(MarioStateMachine2 stateMachine) {
        // do nothing
    }


}
