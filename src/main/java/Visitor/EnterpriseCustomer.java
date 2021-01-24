package Visitor;

public class EnterpriseCustomer extends Customer {
    private String linkman;
    private  String linkTelephone;
    private  String registerAddress;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEnterpriseCustomer(this);
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkTelephone() {
        return linkTelephone;
    }

    public void setLinkTelephone(String linkTelephone) {
        this.linkTelephone = linkTelephone;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }
}
