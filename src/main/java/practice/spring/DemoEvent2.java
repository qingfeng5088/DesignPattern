package practice.spring;

import org.springframework.context.ApplicationEvent;

public class DemoEvent2 extends ApplicationEvent {
    private String message;

    public DemoEvent2(Object source, String message) {
        super(source);
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
