import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class for storing and manipulating information on rooms
 *  @author Volentir Alexandra
 */
public abstract class Room {
    static int counterUnsigned = 0;
    protected String name;
    protected int capacity;
    protected RoomType type;
    protected static Set<String> setOfNames = new HashSet<>();

    /**
     * Constructor for creating the object Room
     * @param name room name
     * @param capacity  the max capacity of the room
     * @param type the room type taken from one of the enum elements
     */
    public Room(String name, int capacity, RoomType type) {
        setName(name);
        this.capacity = capacity;
        this.type = type;
    }

    /**
     * getter for room name
     * @return getter for room name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name setter for room name
     */
    public void setName(String name) {
        if(setOfNames.contains(name)) {
            this.name = "U" + ++counterUnsigned;
        }
        else {
            this.name = name;
        }
        setOfNames.add(this.name);
    }

    /**
     * getter for capacity
     * @return returns the room capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * setter for capacity
     * @param capacity the max room capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * getter for room type
     * @return the value for type
     */
    public RoomType getType() {
        return type;
    }

    /**
     * setter for type
     * @param type sets the type for room (out of enum disposable types)
     */
    public void setType(RoomType type) {
        this.type = type;
    }

    /**
     * overriding of toString method for Room object
     * @return concatenating data on Room object
     */
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }

    /**
     * overriding of equals object method: compares the equality of two objects,
     * mainly in terms of name
     * @param o the object to be compared
     * @return returns true if the given room equals the other room, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return name.equals(room.name);
    }
}
