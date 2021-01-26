package Visitor;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();

        Customer cm1 = new EnterpriseCustomer();
        cm1.setName("ABC集团");
        os.addElement(cm1);

        Customer cm2 = new EnterpriseCustomer();
        cm2.setName("CEF集团");
        os.addElement(cm2);

        Customer cm3 = new PersonalCustomer();
        cm3.setName("邱羽彤");
        os.addElement(cm3);


        ServiceRequestVisitor srVisitor = new ServiceRequestVisitor();
        os.handleRequest(srVisitor);

        PredilectionAnalyzeVisitor paVisitor = new PredilectionAnalyzeVisitor();
        os.handleRequest(paVisitor);

        System.out.println("-------------------以下是观察者模式的实现-----------------------");

        EventBus eventBus = new EventBus();
        eventBus.register(srVisitor);
        eventBus.register(paVisitor);
        eventBus.post(cm1);
        eventBus.post(cm2);
        eventBus.post(cm3);
    }
}
