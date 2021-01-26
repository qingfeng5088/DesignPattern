package Visitor;

import com.google.common.eventbus.Subscribe;

public class ServiceRequestVisitor implements IVisitor {
    @Override
    @Subscribe
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        System.out.println(ec.getName() + "企业提出服务请求!");
    }

    @Override
    @Subscribe
    public void visitPersonalCustomer(PersonalCustomer pc) {
        System.out.println("客户:" + pc.getName() + "提出服务请求!");
    }
}
