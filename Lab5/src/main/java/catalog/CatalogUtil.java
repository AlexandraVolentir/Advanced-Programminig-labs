package catalog;

import exceptions.InvalidCatalogException;
import exceptions.NonexistentInformationToBeSaved;
import exceptions.UnsuccessfulJsonParsing;
import item.GenericItem;
import item.Item;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;


/**
 * utility class that has methods that save and load the items in the Catalog class
 */
public class CatalogUtil {
    /**
     * saves the
     * @param catalog the catalog
     * @param location the location
     * @throws IOException exception I/O
     */
    @SuppressWarnings("unchecked")
    public void save(Catalog catalog, String location) throws IOException, NonexistentInformationToBeSaved, UnsuccessfulJsonParsing {
        if(catalog.getListOfItems().isEmpty()){
            throw new NonexistentInformationToBeSaved("catalog can't be parsed because it is empty");
        }
        System.out.println("list of items:"+ catalog.getListOfItems());
        JSONArray itemJSONList = new JSONArray();
        for(Item item : catalog.getListOfItems()){
            JSONObject itemObject = new JSONObject();
            JSONObject itemDetails = new JSONObject();
            itemDetails.put("id", item.getId());
            itemDetails.put("title", item.getTitle());
            itemDetails.put("location", item.getLocation());
            itemObject.put("item", itemDetails);
            itemJSONList.add(itemObject);
        }
        if(itemJSONList.isEmpty()){
            throw new UnsuccessfulJsonParsing("unsuccessful json parsing");
        }
        System.out.println(itemJSONList);
        FileWriter file = new FileWriter(location);
        file.write(itemJSONList.toJSONString());
        file.flush();
        System.out.println("---The JSON file \"" + location + "\" was successfully populated with catalog data---");
    }

    /**
     * parses the JSON file
     * @param catalog the catalog
     * @param item the item
     */
    public void parseItemObject(Catalog catalog, JSONObject item)
    {
        JSONObject itemObject = (JSONObject) item.get("item");
        String id = (String) itemObject.get("id");
        System.out.println(id);

        String title = (String) itemObject.get("title");
        System.out.println(title);

        String location = (String) itemObject.get("location");
        System.out.println(location);

        Item item1 = new GenericItem(id,title, location);
        catalog.getListOfItems().add(item1);
        System.out.println();
    }

    /**
     * loads the Catalog from the JSON file
     * @param location location
     * @return the loaded new Catalog
     */
    public Catalog load(String location) throws InvalidCatalogException, IOException, ParseException {
        File file = new File(location);
        if(!file.exists()){
            throw new exceptions.InvalidCatalogException("The file " + location + "couldnt be parsed");
        }
        Catalog catalog = new Catalog();
        System.out.println();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(location);
        Object obj = jsonParser.parse(reader);
        JSONArray extractedItemList = (JSONArray) obj;
        extractedItemList.forEach( emp -> parseItemObject( catalog, (JSONObject) emp ));
        System.out.println("---The file was loaded successfully---");
        return catalog;
    }
}
