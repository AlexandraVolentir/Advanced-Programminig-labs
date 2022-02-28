import java.util.HashSet;
import java.util.Set;

public class Room {
    static int counterUnsigned = 0;
    String name;
    int capacity;
    RoomType type;
    static Set<String> setOfNames = new HashSet<>();

    public Room(String name, int capacity, RoomType type) {
        setName(name);
        this.capacity = capacity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(setOfNames.contains(name)) {
            this.name = "U" + ++counterUnsigned;
        }
        else {
            this.name = name;
        }
        setOfNames.add(this.name);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }
}
