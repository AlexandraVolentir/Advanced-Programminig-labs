package command;

import catalog.Catalog;
import item.Item;

public class ListCommand {
    public void execute(Catalog catalog) {
        for(Item item: catalog.getListOfItems()){
            System.out.println(item);
        }
        System.out.println();
    }
}
