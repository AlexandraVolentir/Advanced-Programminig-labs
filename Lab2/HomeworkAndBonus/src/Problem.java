import java.util.ArrayList;

/**
 * class that takes the data input for the room assignment problem
 * @author volentiralexandra
 */
public class Problem {

    private ArrayList<Event> events;
    private ArrayList<Room> rooms;

    /**
     * Constructor for the problem class,
     * that initializes empty ArrayLists of events and rooms
     */
    public Problem() {
        events = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * adding room to the list, verifying first that we haven't worked with this room before
     * this function makes impossible adding the same room to the list
     * @param newRoom the room to be added to the list of rooms
     */
    public void addRoom(Room newRoom) {
        for(Room room : rooms){
            if(room.equals(newRoom)){
                return;
            }
        }
        rooms.add(newRoom);
    }

    public void removeRoom(int index) {
        rooms.remove(index);
    }

    /**
     * adding event to the list, verifying first that we haven't worked with this event before
     * this function makes impossible adding the same event to the list
     * @param newEvent the event to be added to the list of events
     */
    public void addEvent(Event newEvent) {
        for(Event event : events){
            if(event.equals(newEvent)){
                return;
            }
        }
        events.add(newEvent);
    }

    public void removeEvent(int i){
        events.remove(i);
    }
}
