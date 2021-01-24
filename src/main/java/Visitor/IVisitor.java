package Visitor;

public interface IVisitor {
    void visitEnterpriseCustomer(EnterpriseCustomer ec);
    void visitPersonalCustomer(PersonalCustomer pc);
}
