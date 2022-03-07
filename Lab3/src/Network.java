import java.util.ArrayList;

public class Network {
    private ArrayList<Node> listOfNodes;
    Network(){
        listOfNodes = new ArrayList<>();
    }

    public void addNode(Node node){
        listOfNodes.add(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "listOfNodes=" + listOfNodes +
                '}';
    }
}
