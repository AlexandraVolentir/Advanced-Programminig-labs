import java.util.Map;

/**
 * extends the Node class and implements Identifiable
 */
public class Router  extends Node implements Identifiable
{
    private String address;

    /**
     * Router class - it inherits from Node and implements Identifiable
     * used as a node in general
     */
    public Router(String name, String location) {
        super(name, location);
        setType("Router");
        checkAndSetLocation(location);
    }

    /**
     *
     * constructor for router
     */
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
