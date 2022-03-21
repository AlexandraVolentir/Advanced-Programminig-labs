import java.util.*;
import java.util.stream.Collectors;

/**
 * stores data members and methods that make up the street
 */
public class Street {

    private String name;
    private int length;
    private List<Intersection> nodeList;
    static ArrayList<Street> listOfStreets = new ArrayList<>();

    /**
     * constructor for street
     * @param name the name of the street
     * @param length the length of the street
     */
    public Street(String name, int length) {
        this.name = name;
        this.length = length;
        nodeList = new ArrayList<>();
        listOfStreets.add(this);
    }

    /**
     * constructor for street that takes as parameters the names of the two intersections
     * @param name the name of the street
     * @param length the length of the street
     * @param intersection1 the first intersection that has a join with the street
     * @param intersection2 the second intersection that has a join with the street
     */
    public Street(String name, int length, Intersection intersection1, Intersection intersection2) {
        this.name = name;
        this.length = length;
        nodeList = new ArrayList<>();
        nodeList.add(intersection1);
        nodeList.add(intersection2);
        listOfStreets.add(this);
        intersection1.addStreet(this);
        intersection2.addStreet(this);
    }

    /**
     * getter for the name of the street
     * @return the name of the street
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the street
     * @param name the name of the street
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter fot the length of the street
     * @return the length of the street
     */
    public int getLength() {
        return length;
    }

    /**
     * setter for the length of the street
     * @param length the length of the street
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * getter for the nodeList
     * @return
     */
    public List<Intersection> getNodeList() {
        return nodeList;
    }

    /**
     * setter for the nodeList
     * @param nodeList the nodeLsit
     */
    public void setNodeList(List<Intersection> nodeList) {
        this.nodeList = nodeList;
    }

    /**
     * function to add a node to the nodeList
     * @param intersection the intersection object
     */
    public void addNodes(Intersection intersection){
        nodeList.add(intersection);
    }

    /**
     * rewrites the nodeList
     * @param intersections the list with the intersections
     */
    public void addAll(ArrayList<Intersection> intersections){
        this.nodeList = intersections;
    }

    /**
     * static method to compare the streets
     * @param street1 the first street of the comparison
     * @param street2 the second street of the comparison
     * @return the return value of compare
     */
    public static int compareStreetsByLength(Street street1, Street street2) {
        // note - compare t compares only objects
        int length1 = street1.getLength();
        int length2 = street2.getLength();
        return Integer.compare(length1, length2);
    }

    public int findNumberOfJoinedStreets(Street street, ArrayList<Street> arrayOfStreets){
        int counter = 0;
        for(Street streetElement : arrayOfStreets){
            if(!(streetElement == street)
                    || street.getNodeList().get(0).equals(streetElement.getNodeList().get(0))
                    || street.getNodeList().get(0).equals(streetElement.getNodeList().get(1))
                    || street.getNodeList().get(1).equals(streetElement.getNodeList().get(0))
                    || street.getNodeList().get(1).equals(streetElement.getNodeList().get(1)))
            {
                counter++;
            }
        }
        for(Intersection intersection : street.getNodeList()){
            counter += intersection.getStreets().size();
        }
        System.out.println(street + " ");
        System.out.print(counter);
        return counter;
    }

    /**
     * concatenates all the data members of the class
     * in order for them to be represented as an entity
     * @return returns the concatenated elm of street
     */
    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", nodeList=" + nodeList +
                '}';
    }
}
