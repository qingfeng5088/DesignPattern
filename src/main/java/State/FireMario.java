package State;

public class FireMario implements IMario{
    private  static  final FireMario instance = new FireMario();
    private FireMario(){}
    public static FireMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void meetMonster(MarioStateMachine2 stateMachine) {
        System.out.println("------遇到怪物-----");
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() -300);
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
