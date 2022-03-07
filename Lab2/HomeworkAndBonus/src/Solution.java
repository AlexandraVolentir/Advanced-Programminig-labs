import java.util.*;

/**
 * Class that describes the solution of the problem:
 * the hashmap with the assignment of rooms to events
 * @author volentiralexandra
 */
public class Solution {
    private HashMap<Event, Room> assignmentMap;
    private Set<Room> setOfRooms;

    /**
     * constructor for the Solution class
     */
    public Solution() {
        assignmentMap = new HashMap();
        setOfRooms = new HashSet<>();
    }

    public HashMap<Event, Room> getAssignmentMap() {
        return assignmentMap;
    }

    /**
     * setter for the assignmentMap
     * @param assignmentMap contains in the key - the Event, and the
     *                      value - the Room.
     */
    public void setAssignmentMap(HashMap<Event, Room> assignmentMap) {
        this.assignmentMap = assignmentMap;
    }

    /**
     * adds to the HashMap an room-to-event assignment
     * @param event  event
     * @param room room assigned to the event
     */
    public void addPair(Event event, Room room){
        assignmentMap.put(event, room);
    }

    /**
     * method that outputs on the screen the final assignment of the rooms and events
     * as well, it calculated the number of rooms used for the approach
     */
    public void computeUsedRooms() {
        System.out.println("\nThe solution is:");
        for (Map.Entry<Event, Room> entry : assignmentMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " ===> " + entry.getValue().getName());
            setOfRooms.add(entry.getValue());
        }
        System.out.println("The used rooms were: ");
        int counter = 0;
        for(var obj : setOfRooms){
            System.out.print(obj.getName() + " ");
            counter++;
        }
        System.out.print("\n\n" + counter + " rooms were used for scheduling " + assignmentMap.size()  + " events\n\n");
    }

    public void addToSetOfRooms(Room room){
        setOfRooms.add(room);
    }

    /**
     * setter fo set of rooms
     * @return setOfRooms
     */
    public Set<Room> getSetOfRooms() {
        return setOfRooms;
    }

    /**
     * setter for setOfRooms
     * @param setOfRooms a set of rooms
     */
    public void setSetOfRooms(Set<Room> setOfRooms) {
        this.setOfRooms = setOfRooms;
    }
}
