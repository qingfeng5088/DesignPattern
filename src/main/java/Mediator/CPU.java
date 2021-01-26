package Mediator;

public class CPU extends Colleague {
    private String videoData = "";
    private String soundData = "";

    public CPU(IMediator mediator) {
        super(mediator);
    }

    public String getVideoData() {
        return videoData;
    }

    public String getSoundData() {
        return soundData;
    }

    public void executeData(String data) {
        String[] ss = data.split(",");
        this.videoData = ss[0];
        this.soundData = ss[1];

        this.getMediator().changed(this);
    }

}
