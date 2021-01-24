package State;

public class MarioStateMachine {
    private int score;
    private State currentState;



    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 获得蘑菇
     */
    public void obtainMushRoom() {
        if(this.currentState != State.SMALL) return;
        System.out.println("----获得蘑菇---");
        this.currentState = State.SUPER;
        this.score += 100;
    }

    /**
     * 获得斗篷
     */
    public void obtainCape() {
        if(this.currentState != State.SMALL && this.currentState != State.SUPER) return;
        System.out.println("----获得斗篷---");
        this.currentState = State.CAPE;
        this.score += 200;
    }

    /**
     * 获得火焰
     */
    public void obtainFireFlower() {
        if(this.currentState != State.SMALL && this.currentState != State.SUPER) return;
        System.out.println("---获得火焰---");
        this.currentState = State.FIRE;
        this.score += 300;
    }

    /**
     * 遇到怪物
     */
    public void meetMonster() {
        System.out.println("---遇到怪物---");
        if (this.currentState == State.FIRE) {
            this.score -= 300;
        } else if(this.currentState == State.SUPER) {
            this.score -=100;
        } else  if (this.currentState == State.CAPE) {
            this.score -=200;
        }

        this.currentState = State.SMALL;
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

}
