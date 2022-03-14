import java.util.Map;

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;
    public Computer(String name) {
        super(name);
        setType("Computer");
        checkAndSetName(name);
    }
    public Computer(String name, Map<Node, Integer> cost) {
        super(name, cost);
        setType("Computer");
        checkAndSetName(name);
    }

    public void setStorageCapacity(int storage){
        this.storageCapacity = storage;
    }

    @Override
    public int getStorageCapacity() {
        return 0;
    }

    @Override
    public String getAddress() {
        return null;
    }

    public int setAddress(String address){
        return storageCapacity;
    }
}
