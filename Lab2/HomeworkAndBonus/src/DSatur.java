import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class for solving a scheduling problem with DSatur algorithm
 * @author volentiralexandra
 */
public class DSatur extends Algorithm {

    private HashMap<Event, ArrayList<Event>> graph; // adjacency list
    private HashMap<Event, Integer> saturation;

    /**
     * constructor for the DSatur class
     * points to the constructor of the super class
     *
     * @param pb the instance of the problem
     */
    public DSatur(Problem pb) {
        super(pb);
        graph = new HashMap<>();
        saturation = new HashMap<>();
    }

    /**
     * calculated if the events have an interval in common
     *
     * @param ev1 fist event
     * @param ev2 second event
     * @return return the boolean value of the truth statement
     */
    public boolean calculateIfTimeCoincides(Event ev1, Event ev2) {
        return (ev1.getStartTime().isBefore(ev2.getEndTime()) &&
                (ev1.getEndTime().isAfter(ev2.getStartTime())));

    }

    /**
     * initializes the hash maps
     */
    public void initializeHashMap() {
        for (Event event1 : pb.getEvents()) {
            ArrayList<Event> arr = new ArrayList<>();
            graph.put(event1, arr);
        }

        for (Event event1 : pb.getEvents()) {
            saturation.put(event1, 0);
        }
    }

    /**
     * calculates the adjacency list and the saturation of nodes
     */
    public void getAdjacencyList() {
        for (Event event1 : pb.getEvents()) {
            for (Event event2 : pb.getEvents()) {
                if (calculateIfTimeCoincides(event1, event2)) {
                    graph.get(event1).add(event2);
                    saturation.put(event1, saturation.get(event1) + 1);
                }
            }
        }
    }

    /**
     * gets the maximum saturation
     * @return returns the maximum saturation
     */
    public Event getMaxSaturation() {
        int max = 0;
        Event ev = null;
        for (Map.Entry<Event, Integer> entry : saturation.entrySet()) {
            Object value = entry.getValue();
            if ((int) value > max) {

                max = (int) value;
                ev = entry.getKey();
            }
        }
        return ev;
    }

    /**
     * performs the dsatur algorithm
     * @param ev most saturated event
     * @param pb problem instance
     * @return returns the dsatur solution
     */
    public Solution actualDsatur(Event ev, Problem pb) {
        Solution sol = new Solution();
        for (Map.Entry<Event, ArrayList<Event>> entry : graph.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key.equals(ev)) {
                sol.addPair(ev, pb.getRooms().get(0));
                sol.addToSetOfRooms(pb.getRooms().get(0));
                for (Map.Entry<Event, ArrayList<Event>> entry2 : graph.entrySet()) {
                    Event key1 = entry.getKey();
                    Object value1 = entry.getValue();
                    for (var obj : pb.getRooms()) {
                        if (!sol.getSetOfRooms().contains(obj)) {
                            sol.addPair(key1, obj);
                            sol.addToSetOfRooms(obj);
                        }
                    }
                }
            }
        }
        return sol;
    }



    /**
     * function for solving Dsatur where
     * the events are the nodes, the rooms are colors
     * and the adjacency between nodes happens when they are in the same
     * hour interval
     * @return the solution of DSatur
     */
    @Override
    public Solution solve() {
        pb.getEvents().sort(new EventsComparator());
        pb.getRooms().sort(new RoomsComparator());
        initializeHashMap();
        getAdjacencyList();
        Event ev = getMaxSaturation();
        return actualDsatur(ev, pb);
//        System.out.println(pb.getEvents());
//        System.out.println(pb.getRooms());
    }
}