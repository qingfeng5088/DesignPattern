package practice.spring;

import org.springframework.context.ApplicationListener;

//Listener
public class DemoListener2 implements ApplicationListener<DemoEvent2> {
    @Override
    public void onApplicationEvent(DemoEvent2 demoEvent) {
        String message = demoEvent.getMessage();

        System.out.println("这是第二个示例");
        System.out.println(message);
    }
}
