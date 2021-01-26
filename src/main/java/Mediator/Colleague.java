package Mediator;

public abstract class Colleague {
    private final IMediator mediator;

    public Colleague(IMediator mediator) {
        this.mediator = mediator;
    }

    public IMediator getMediator() {
        return mediator;
    }
}
