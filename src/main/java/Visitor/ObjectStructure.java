package Visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ObjectStructure {
    private final Collection<Customer> col = new ArrayList<>();

    public void handleRequest(IVisitor visitor) {
        for (Customer customer : col) {
            customer.accept(visitor);
        }
    }

    public  void addElement(Customer ele) {
        col.add(ele);
    }

}
