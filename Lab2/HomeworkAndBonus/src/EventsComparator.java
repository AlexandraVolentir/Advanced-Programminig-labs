import java.util.Comparator;

/**
 * Class to compare the starting time of Events
 * used for sorting an ArrayList in the GreedyAlgorithm class
 * @author volentiralexandra
 */
public class EventsComparator implements Comparator<Event> {

    /**
     * compares two events based on their starting time
     * @param o1 first Event object
     * @param o2 second Event object
     * @return the value of the comparison of the starting time
     */
    @Override
    public int compare(Event o1, Event o2) {
        return Integer.compare(o1.getStartTimeHour(), o2.getStartTimeHour());
    }
}
