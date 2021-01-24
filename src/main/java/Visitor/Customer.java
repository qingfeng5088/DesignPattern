package Visitor;

public abstract class Customer {
    private String customerId;
    private String name;

    /**
     * 接受访问者的访问
     * @param visitor
     */
    public abstract  void accept(IVisitor visitor);

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
