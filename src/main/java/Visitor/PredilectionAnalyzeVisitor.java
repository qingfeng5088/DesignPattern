package Visitor;
public class PredilectionAnalyzeVisitor implements  IVisitor{
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer ec) {
        System.out.println("现在对企业客户" +ec.getName() + "进行产品偏好分析...");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer pc) {
        System.out.println("现在对个人客户" +pc.getName() + "进行产品偏好分析...");
    }
}
