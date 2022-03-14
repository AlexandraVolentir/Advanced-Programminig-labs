public interface Storage {
    public int getStorageCapacity();

    /**
     * setter for storage capacity
     */
    public void setStorageCapacity(int storage);

    /**
     * translates into different storage units
     */
    default long translate(int gb, StorageUnits type) {
        if(type == StorageUnits.BYTE){
            return 1073741824L *gb;
        }
        else if(type == StorageUnits.KILOBYTE){
            return 1000000L*gb;
        }
        else if(type == StorageUnits.MEGABYTE){
            return 1024L*gb;
        }
        return gb;
    }
}
