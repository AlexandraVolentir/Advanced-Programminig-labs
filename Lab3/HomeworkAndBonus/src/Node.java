import java.util.*;

public class Node implements Comparable<Node>{
    private String name;
    private String location;
    private Map<Node, Integer> cost;
    private Map<Node, Double> failureProbability;
    private Map<Node, Double> logarithmicProbability;
    private static int idCounter = 0;
    private int id;

    private String type;
    private static Set<String> setOfLocations = new HashSet<>();
    static int counter = 0;

    public Node(String name, String location) {
        setName(name);
        cost = new HashMap<>();
        id= idCounter++;
    }

    public Node(String name, String location ,Map<Node, Integer> cost) {
        setName(name);
        this.cost = new HashMap<>(cost);
        id = idCounter++;
    }

    public Map<Node, Double> getLogarithmicProbability() {
        return logarithmicProbability;
    }

    public void setLogarithmicProbability(Map<Node, Double> logarithmicProbab) {
        this.logarithmicProbability = logarithmicProbab;
    }

    public void setLogarithmicProbability(Node n, double value) {
        this.logarithmicProbability.put(n,value);
    }


    public Map<Node, Double> getFailureProbability() {
        return failureProbability;
    }

    public void setFailureProbability(Map<Node, Double> failureProbability) {
        this.failureProbability = failureProbability;
    }

    public void setFailureProbability(Node key, double i) {
        failureProbability.put(key, i);
    }

    public static void increseIdCounter() {
        idCounter++;
    }

    public static int getIdCounter() {
        return idCounter;
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

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
