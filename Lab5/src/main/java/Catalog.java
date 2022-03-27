import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;


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

    public void parseItemObject(JSONObject item)
    {
        JSONObject itemObject = (JSONObject) item.get("item");
        String id = (String) itemObject.get("id");
        System.out.println(id);

        String title = (String) itemObject.get("title");
        System.out.println(title);

        String location = (String) itemObject.get("location");
        System.out.println(location);

        Item item1 = new GenericItem(id,title, location);
        listOfItems.add(item1);
        System.out.println();
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
        System.out.println("list of items:"+ listOfItems);
        JSONArray itemJSONList = new JSONArray();
        for(Item item : listOfItems){
            JSONObject itemObject = new JSONObject();
            JSONObject itemDetails = new JSONObject();
            itemDetails.put("id", item.getId());
            itemDetails.put("title", item.getTitle());
            itemDetails.put("location", item.getLocation());
            itemObject.put("item", itemDetails);
            itemJSONList.add(itemObject);
        }
        System.out.println(itemJSONList);
        try (FileWriter file = new FileWriter("catalog.json")) {
            file.write(itemJSONList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        System.out.println();
        listOfItems.clear();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("catalog.json"))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray extractedItemList = (JSONArray) obj;
//            System.out.println(extractedItemList);
            extractedItemList.forEach( emp -> parseItemObject( (JSONObject) emp ) );

        } catch (IOException | ParseException e) {
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
