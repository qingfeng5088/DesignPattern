package State;

public interface IMario {
    State getName();
    void obtainMushRoom(MarioStateMachine2 stateMachine);
    void obtainCape(MarioStateMachine2 stateMachine);
    void obtainFireFlower(MarioStateMachine2 stateMachine);
    void meetMonster(MarioStateMachine2 stateMachine);
}
