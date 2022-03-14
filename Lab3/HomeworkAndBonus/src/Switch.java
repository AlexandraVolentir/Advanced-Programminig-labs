import java.util.Map;

public class Switch extends Node{

    public Switch(String name) {
        super(name);
        setType("Switch");
        checkAndSetName(name);
    }

    public Switch(String name, Map<Node, Integer> cost) {
        super(name, cost);
        setType("Switch");
        checkAndSetName(name);
    }
}
