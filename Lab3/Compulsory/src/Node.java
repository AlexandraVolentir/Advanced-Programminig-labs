import javax.xml.stream.Location;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node implements Comparable<Node>{
    private String name;
    private Map<Node, Integer> cost;
    private static Set<String> setOfNodeNames = new HashSet<>();
    static int counter = 0;

    public Node(String name) {
        checkAndSetName(name);
        cost = new HashMap<>();
    }

    public Node(String name, Map<Node, Integer> cost) {
        checkAndSetName(name);
        this.cost = new HashMap<>(cost);
    }

    public static Set<String> getSetOfNodeNames() {
        return setOfNodeNames;
    }

    public static void setSetOfNodeNames(Set<String> setOfNodeNames) {
        Node.setOfNodeNames = setOfNodeNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkAndSetName(name);
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

    public void checkAndSetName(String name){
        if(setOfNodeNames.contains(name)){
            this.name = "default" + ++counter;
        }
        else {
            this.name = name;
        }
        setOfNodeNames.add(this.name);
    }

    @Override
    public int compareTo(Node other) {
        if(this.name != null) return this.name.compareTo(other.name);
        return -1;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' + "}";
    }
}
