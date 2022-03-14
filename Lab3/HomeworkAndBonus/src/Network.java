import java.util.ArrayList;
import java.util.Collections;

public class Network {
    private ArrayList<Node> listOfNodes;
    public Network(){
        listOfNodes = new ArrayList<>();
    }

    public Network(ArrayList<Node> nodes){
        listOfNodes = new ArrayList<>(nodes);
    }

    public Network(Network n1) {
        listOfNodes = n1.listOfNodes;
    }

    public ArrayList<Node> getListOfNodes() {
        return listOfNodes;
    }

    public void setListOfNodes(ArrayList<Node> listOfNodes) {
        this.listOfNodes = listOfNodes;
    }

    public void setCost(Node n1, Node n2, int value){
        n1.setCost(n2, value);
        n2.setCost(n1, value);
    }

    public void addNode(Node node){
        listOfNodes.add(node);
    }

    public void removeNode(Node node){
        listOfNodes.remove(node);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nThe costs of the graph are:\n");
        for(var obj: listOfNodes){
            str.append(obj.getName()).append(obj.getCost()).append("\n");
        }
        return str.toString();
    }

    public ArrayList<Node> sortByAddressesIdentifiable(ArrayList<Node> list){

        ArrayList<Node> temp = new ArrayList<>();
        for(var obj : listOfNodes){
            if(obj instanceof Identifiable){
                temp.add(obj);
//                obj.setId(Node.getIdCounter());
//                Node.increseIdCounter();
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public void displayIdentifiable(){
        ArrayList<Node> temp = sortByAddressesIdentifiable(listOfNodes);
        for(var obj : temp){
            System.out.println(obj.getName() +  " (" + obj.getLocation() + ")");
        }
    }
}
