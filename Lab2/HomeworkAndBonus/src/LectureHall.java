/**
 * extension of the Room class - LectureHall
 * @author volentiralexandra
 */
public class LectureHall extends Room{
    boolean hasProjector;

    /**
     * constructor for the LectureHall class
     * calls the extended abstract class constructor from inside
     * @param name the name of the room
     * @param capacity capacity of the room
     */
    public LectureHall(String name, int capacity) {
        super(name, capacity, RoomType.LECTURE_HALL);
        hasProjector = false;
    }

    /**
     * setter for hasProjector
     */
    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    /**
     * getter fot setProjector
     * @return the truth statement of having a projector in the hall
     */
    public boolean getHasProjector() {
        return hasProjector;
    }
}
