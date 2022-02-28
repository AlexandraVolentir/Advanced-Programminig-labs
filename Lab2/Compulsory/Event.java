public class Event {
    String  name;
    int nrOfParticipants;
    int startTime, endTime;

    public Event(String name, int nrOfParticipants, int startTime, int endTime) {
        this.name = name;
        this.nrOfParticipants = nrOfParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfParticipants() {
        return nrOfParticipants;
    }

    public void setNrOfParticipants(int nrOfParticipants) {
        this.nrOfParticipants = nrOfParticipants;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", nrOfParticipants=" + nrOfParticipants +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
