import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Location>{
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node(String name, Map<Node, Integer> cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Node node, int value){
        cost.put(node, value);
    }

    @Override
    public int compareTo(Location other) {
//        return this.name.compareTo(other.);
        return 0;
    }
}
