import java.util.Map;

public class Router  extends Node implements Identifiable
{

    private String address;

    public Router(String name, String location) {
        super(name, location);
        setType("Router");
        checkAndSetLocation(location);
    }

    public Router(String name, String location,Map<Node, Integer> cost) {
        super(name, location, cost);
        setType("Router");
        checkAndSetLocation(location);
    }

    @Override
    public String getAddress() {
        return null;
    }
}
