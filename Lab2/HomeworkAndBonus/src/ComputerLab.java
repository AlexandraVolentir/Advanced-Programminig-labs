/**
 * extension of the Room class - ComputerHall
 * implements in addition to base methods get/setOperatingSystem
 * @author volentiralexandra
 */
public class ComputerLab extends Room{

    private String operatingSystem;

    /**
     * constructor for ComputerLab class that calls the base constructor inside
     * @param name the name of the room
     * @param capacity capacity of the room
     */
    public ComputerLab(String name, int capacity) {
        super(name, capacity, RoomType.LABORATORY);
        operatingSystem = "Windows"; // default operating system
    }

    /**
     * getter for the operating system
     * @return operating system of the room
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * setter for the operating system
     * @param operatingSystem name of the operating system installed
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
