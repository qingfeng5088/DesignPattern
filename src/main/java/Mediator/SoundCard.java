package Mediator;

public class SoundCard extends Colleague {
    public SoundCard(IMediator mediator) {
        super(mediator);
    }

    public void soundData(String data) {
        System.out.println("画外音:"+ data);
    }
}
