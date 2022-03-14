import java.util.Map;

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;
    public Computer(String name, String location) {
        super(name, location);
        setType("Computer");
        checkAndSetLocation(location);
    }
    public Computer(String name, String location, Map<Node, Integer> cost) {
        super(name, location, cost);
        setType("Computer");
        checkAndSetLocation(location);
    }

    public void setStorageCapacity(int storage){
        this.storageCapacity = storage;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String getAddress() {
        return null;
    }

    public int setAddress(String address){
        return storageCapacity;
    }
}
