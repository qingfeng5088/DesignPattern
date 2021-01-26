package Command;

public class Test {
    public static void main(String[] args) {
        IMainBoardApi mainBoardApi = new GigaMainBoard();
        OpenCommand openCommand = new OpenCommand(mainBoardApi);
        System.out.println("-------------开机------------");
        Box box = new Box();
        box.setOpenCommand(openCommand);
        box.openButtonPressed();

        System.out.println("-------------重启------------");
        RestartCommand restartCommand = new RestartCommand(mainBoardApi);
        box.setRestartCommand(restartCommand);
        box.restartButtonPressed();
    }
}
