public class Computer implements Identifiable, Storage{
    private String address;
    private int storageCapacity;


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
