import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.List;
import java.util.*;
import java.util.stream.*;


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
        return "Catalog{" +
                "listOfItems=" + listOfItems +
                '}';
    }
}
