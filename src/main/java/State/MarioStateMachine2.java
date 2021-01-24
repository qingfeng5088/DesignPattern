package State;

public class MarioStateMachine2 {
    private int score;
    private IMario currentState;

    public MarioStateMachine2() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
