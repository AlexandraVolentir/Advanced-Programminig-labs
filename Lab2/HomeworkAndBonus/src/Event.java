import java.time.Clock;

/**
 * Class for creating and managing events
 * @author volentiralexandra
 */
public class Event {
    private int index;
    private static int indexCounter = 0;
    private String  name;
    private int nrOfParticipants;
    private int startTime, endTime;

    /**
     *
     * @param name the name of the event
     * @param nrOfParticipants the expected size of participants
     * @param startTime when the event starts
     * @param endTime when the event ends
     */
    public Event(String name, int nrOfParticipants, int startTime, int endTime) {

        this.name = name;
        this.nrOfParticipants = nrOfParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = ++indexCounter;
    }

    /**
     * getter for name
     * @return name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for number of participants
     * @return number of participants at the event
     */
    public int getNrOfParticipants() {
        return nrOfParticipants;
    }

    /**
     * setter for nrOfParticipants
     * @param nrOfParticipants number of people expected to come to the event
     */
    public void setNrOfParticipants(int nrOfParticipants) {
        this.nrOfParticipants = nrOfParticipants;
    }

    /**
     * getter for startTime
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * setter for startTime
     * @param startTime time when the event Starts
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Function for concatenating all the information on events
     * @return the concatenated string
     */
    @Override
    public String toString() {
        return "Event{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", nrOfParticipants=" + nrOfParticipants +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    /**
     * overriding of equals object method: compares the equality of two objects,
     * mainly in terms of name
     * @param o the object to be compared
     * @return returns true if the given event equals the other event, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return name.equals(event.name);
    }
}
