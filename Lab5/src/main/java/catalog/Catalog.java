package catalog;

import java.io.Serializable;
import java.util.ArrayList;
import item.Item;
import java.util.List;

/**
 * catalog class that stores lists of items
 */
public class Catalog implements Serializable {
    private List<Item> listOfItems;

    /**
     * default constructor for catalog
     */
    public Catalog(){
        this.listOfItems = new ArrayList<>();
    }

    /**
     * constructor for catalog
     * @param listOfItems list of items
     */
    public Catalog(ArrayList<Item> listOfItems) {
        this.listOfItems = new ArrayList<>(listOfItems);
    }

    /**
     * getter for the list of items
     * @return the list of items
     */
    public List<Item> getListOfItems() {
        return (ArrayList<Item>) listOfItems;
    }

    /**
     * setter for the list of items
     * @param listOfItems list of items
     */
    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    /**
     * function that finds an item by its id
     * @param id id of the item
     * @return the found item
     */
    public Item findById(String id){
        return listOfItems.stream()
                .filter(d->d.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * adds an item to the catalog
     * @param item the given item
     */
    public void add(Item item){
        for(Item existentItem : listOfItems){
            if(item.getId().equals(existentItem.getId())){
                return;
            }
        }
        listOfItems.add(item);
    }

    /**
     * toString method that concatenates the data members of the Catalog class
     * @return
     */
    @Override
    public String toString() {
        return "catalog.Catalog{" +
                "listOfItems=" + listOfItems +
                '}';
    }
}
