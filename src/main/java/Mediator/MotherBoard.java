package Mediator;

public class MotherBoard implements IMediator {
    private CDDriver cdDriver;
    private CPU cpu;
    private SoundCard soundCard;
    private VideoCard videoCard;

    public void setCdDriver(CDDriver cdDriver) {
        this.cdDriver = cdDriver;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    @Override
    public void changed(Colleague colleague) {
        if (colleague == cdDriver) {
            this.opeCDDriverReadData((CDDriver) colleague);
        } else if (colleague == cpu) {
            this.opeCPU((CPU) colleague);
        }
    }

    private void opeCDDriverReadData(CDDriver cd) {
        String data = cd.getData();
        this.cpu.executeData(data);
    }

    private void opeCPU(CPU cpu) {
        String videoData = cpu.getVideoData();
        String soundData = cpu.getSoundData();

        this.videoCard.showData(videoData);
        this.soundCard.soundData(soundData);
    }
}
