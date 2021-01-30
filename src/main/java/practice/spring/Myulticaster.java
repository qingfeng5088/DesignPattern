package practice.spring;


import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

@Component(value = "applicationEventMulticaster")
public class Myulticaster extends SimpleApplicationEventMulticaster {
    public Myulticaster() {
        setTaskExecutor(Executors.newCachedThreadPool());
    }
}