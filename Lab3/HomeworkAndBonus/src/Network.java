import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

    public void setCost(Node n1, Node n2, int value){
        n1.setCost(n2, value);
        n2.setCost(n1, value);
    }

    public void addNode(Node node){
        listOfNodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
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
            }
        }
        Collections.sort(temp);
        return temp;
    }

    public void displayIdentifiable(){
        System.out.println(sortByAddressesIdentifiable(listOfNodes));
        System.out.println(sortByAddressesIdentifiable(listOfNodes));
    }
}
