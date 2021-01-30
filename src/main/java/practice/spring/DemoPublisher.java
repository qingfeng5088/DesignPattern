package practice.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(ApplicationEvent demoEvent) {
        this.applicationContext.publishEvent(demoEvent);
    }

    public static void main(String[] args) {
        DemoPublisher demoPublisher = new DemoPublisher();
        demoPublisher.applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        DemoEvent demoEvent = new DemoEvent("D","你好，邱羽彤");
        DemoEvent2 demoEvent2 = new DemoEvent2("D","你好，邱春波");
       // demoPublisher.publishEvent(demoEvent2);
        demoPublisher.publishEvent(demoEvent);
    }
}
