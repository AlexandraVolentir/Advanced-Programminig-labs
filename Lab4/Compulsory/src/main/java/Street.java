import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Street {

    private String name;
    private String length;
    List<Intersection> nodeList = new ArrayList<>();

    public Street(String name, String length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public List<Intersection> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Intersection> nodeList) {
        this.nodeList = nodeList;
    }

    public void addNodes(Intersection intersection){
        nodeList.add(intersection);
    }

    public void addAll(ArrayList<Intersection> intersections){
        this.nodeList = intersections;
    }

    public void sorting(){
        Collections.sort(nodeList, ((u,v) -> u.getName().compareTo(v.getName())));;
    }

}
