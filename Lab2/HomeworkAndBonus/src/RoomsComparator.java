import java.util.Comparator;

/**
 * Class to compare the capacity of Rooms
 * used for sorting an ArrayList in the GreedyAlgorithm class
 * @author volentiralexandra
 */
public class RoomsComparator implements Comparator<Room> {
    /**
     * compares two rooms based on their capacity
     * @param o1 first Room object
     * @param o2 second Room object
     * @return returns the result of the comparison
     */
    @Override
    public int compare(Room o1, Room o2) {
        return Integer.compare(o1.getCapacity(), o2.getCapacity());
    }
}
