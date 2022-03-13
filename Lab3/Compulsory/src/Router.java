import java.util.Map;

public class Router  extends Node implements Identifiable
{

    private String address;

    public Router(String name) {
        super(name);
    }

    public Router(String name, Map<Node, Integer> cost) {
        super(name, cost);
    }

    @Override
    public String getAddress() {
        return null;
    }

}
