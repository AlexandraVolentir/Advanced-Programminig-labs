package catalog;

import java.io.Serializable;
import java.util.ArrayList;

import item.Item;

import java.util.List;


public class Catalog implements Serializable {
    private List<Item> listOfItems;

    public Catalog(){
        this.listOfItems = new ArrayList<>();
    }

    public Catalog(ArrayList<Item> listOfItems) {
        this.listOfItems = new ArrayList<>(listOfItems);
    }

    public List<Item> getListOfItems() {
        return (ArrayList<Item>) listOfItems;
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public Item findById(String id){
        return listOfItems.stream()
                .filter(d->d.getId().equals(id)).findFirst().orElse(null);
    }



    public void add(Item item){
        for(Item existentItem : listOfItems){
            if(item.getId().equals(existentItem.getId())){
                return;
            }
        }
        listOfItems.add(item);
    }

    @Override
    public String toString() {
        return "catalog.Catalog{" +
                "listOfItems=" + listOfItems +
                '}';
    }
}
