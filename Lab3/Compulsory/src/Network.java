import java.util.ArrayList;

public class Network {
    private ArrayList<Node> listOfNodes;
    public Network(){
        listOfNodes = new ArrayList<>();
    }

    public Network(ArrayList<Node> nodes){
        listOfNodes = new ArrayList<>(nodes);
    }

    public ArrayList<Node> getListOfNodes() {
        return listOfNodes;
    }

    public void setListOfNodes(ArrayList<Node> listOfNodes) {
        this.listOfNodes = listOfNodes;
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
