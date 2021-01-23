package Observer_api;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Reader implements PropertyChangeListener {
    private  String name;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(name+"收到报纸了，阅读它。内容是====" + evt.getNewValue());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
