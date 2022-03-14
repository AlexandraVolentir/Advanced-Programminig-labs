import java.util.Map;

public class Switch extends Node{

    public Switch(String name, String location) {
        super(name, location);
        setType("Switch");
        checkAndSetLocation(location);
    }

    public Switch(String name,String location, Map<Node, Integer> cost) {
        super(name, location, cost);
        setType("Switch");
        checkAndSetLocation(location);
    }
}
