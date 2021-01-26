package Command;

/**
 * 机箱类
 */
public class Box {
    /**
     * 开机命令对象
     */
    private ICommand openCommand;

    private  ICommand restartCommand;

    public void setOpenCommand(ICommand openCommand) {
        this.openCommand = openCommand;
    }

    public void setRestartCommand(ICommand restartCommand) {
        this.restartCommand = restartCommand;
    }

    /**
     * 执行开机命令
     */
    public void openButtonPressed(){
        openCommand.execute();
    }

    /**
     * 执行重启命令
     */
    public void restartButtonPressed(){
        restartCommand.execute();
    }
}
