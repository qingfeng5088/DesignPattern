package Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private final String name;
    private List<Component> children = null;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void addChild(Component child) {
        if(children == null) {
            children = new ArrayList<Component>();
        }

        children.add(child);
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);

        if(this.children == null) return;
        preStr += " ";

        for (Component child : children) {
            child.printStruct(preStr);
        }

    }
}
