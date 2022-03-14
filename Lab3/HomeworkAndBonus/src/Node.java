import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node implements Comparable<Node>{
    private String name;
    private String location;
    private Map<Node, Integer> cost;

    private String type;
    private static Set<String> setOfLocations = new HashSet<>();
    static int counter = 0;

    public Node(String name, String location) {
        setName(name);
        cost = new HashMap<>();
    }

    public Node(String name, String location ,Map<Node, Integer> cost) {
        setName(name);
        this.cost = new HashMap<>(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Set<String> getSetOfLocations() {
        return setOfLocations;
    }

    public static void setSetOfLocations(Set<String> setOfLocations) {
        Node.setOfLocations = setOfLocations;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        checkAndSetLocation(location);
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

    public void setType(String type) {
        this.type = type;
    }

    public void checkAndSetLocation(String location){
        this.location = type + " " + location;
        if(setOfLocations.contains(location)){
            this.location = "default" + ++counter;
        }
        setOfLocations.add(this.location);
    }

    @Override
    public int compareTo(Node other) {
        if(this.location != null) return this.location.compareTo(other.location);
        return -1;
    }

    @Override
    public String toString() {
        String returnVal = "Node[" +
                "name='" + name + '\'' +
                ']';
        return returnVal;
    }

    public String getType() {
        return type;
    }
}
