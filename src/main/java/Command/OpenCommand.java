package Command;

public class OpenCommand implements ICommand {
    private IMainBoardApi mainBoard = null;

    public OpenCommand(IMainBoardApi mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        //对于命令对象，根本不知道如何开机，只会调主板对象
        //让主板去完成开机任务
        this.mainBoard.open();
    }
}
