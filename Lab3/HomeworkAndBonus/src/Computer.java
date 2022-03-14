import java.util.Map;

/**
 * computer class that extends the Node class and implements
 * Identifiable and Storage
 * This means that it is the only class which can have an instance
 * both with storage space and ip address
 */
public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;

    /**
     * constructor for the computer class
     */
    public Computer(String name, String location) {
        super(name, location);
        setType("Computer");
        checkAndSetLocation(location);
    }

    /**
     *
     * @param name gets the name of the computer
     * @param location location
     * @param cost sets the general costs with other nodes
     */
    public Computer(String name, String location, Map<Node, Integer> cost) {
        super(name, location, cost);
        setType("Computer");
        checkAndSetLocation(location);
    }

    /**
     * setter for storage capacity
     */
    public void setStorageCapacity(int storage){
        this.storageCapacity = storage;
    }

    /**
     * getter for storage capacity
     */
    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    /**
     * getter for address
     */
    @Override
    public String getAddress() {
        return null;
    }
}
