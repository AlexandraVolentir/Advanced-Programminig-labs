import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Catalog {
    private ArrayList<Item> listOfItems;

    public Catalog(){
        this.listOfItems = new ArrayList<>();
    }

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
        for(Item existentItem : listOfItems){
            if(item.getId().equals(existentItem.getId())){
                return;
            }
        }
        listOfItems.add(item);
    }

    @SuppressWarnings("unchecked")
    public void save(){
        //ArrayList<Item> listOfItems = new ArrayList<>();
        System.out.println("list of items:"+ listOfItems);
        JSONArray itemJSONList = new JSONArray();
        for(Item item : listOfItems){
            JSONObject itemObject = new JSONObject();
            JSONObject itemDetails = new JSONObject();
            itemDetails.put("id", item.getId());
            itemDetails.put("title", item.getTitle());
            itemDetails.put("location", item.getLocation());
//            System.out.println("am fost aici" + itemDetails);
            itemObject.put("item", itemDetails);
            itemJSONList.add(itemObject);
        }
        System.out.println(itemJSONList);
        try (FileWriter file = new FileWriter("catalog.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(itemJSONList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "listOfItems=" + listOfItems +
                '}';
    }
}
