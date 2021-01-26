package Command;

public class RestartCommand implements  ICommand {
    private IMainBoardApi mainBoard = null;

    public RestartCommand(IMainBoardApi mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        this.mainBoard.restart();
    }
}
