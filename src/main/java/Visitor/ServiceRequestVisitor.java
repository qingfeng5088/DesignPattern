package Visitor;

public class ServiceRequestVisitor implements IVisitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        System.out.println(ec.getName() + "企业提出服务请求!");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        System.out.println("客户:" + pc.getName() + "提出服务请求!");
    }
}
