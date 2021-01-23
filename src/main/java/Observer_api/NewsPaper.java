package Observer_api;

import java.beans.PropertyChangeSupport;
public class NewsPaper  {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public  void attach(Reader reader) {
        pcs.addPropertyChangeListener(reader);
    }

    protected  void notifyObservers(String content){
        pcs.firePropertyChange("newspaper",null,content);
    }
}
