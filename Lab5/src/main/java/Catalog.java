import java.util.ArrayList;

public class Catalog {
    private ArrayList<Item> listOfItems;

    public Catalog(ArrayList<Item> listOfItems) {
        this.listOfItems = new ArrayList<>(listOfItems);
    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public void add(Item item){
        listOfItems.add(item);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "listOfItems=" + listOfItems +
                '}';
    }
}
