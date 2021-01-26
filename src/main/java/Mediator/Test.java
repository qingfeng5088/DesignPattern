package Mediator;

public class Test {
    public static void main(String[] args) {
        MotherBoard motherBoard = new MotherBoard();
        CDDriver cdDriver = new CDDriver(motherBoard);
        CPU cpu = new CPU(motherBoard);
        VideoCard videoCard = new VideoCard(motherBoard);
        SoundCard soundCard = new SoundCard(motherBoard);

        motherBoard.setCdDriver(cdDriver);
        motherBoard.setCpu(cpu);
        motherBoard.setVideoCard(videoCard);
        motherBoard.setSoundCard(soundCard);

        cdDriver.readCD();
    }
}
