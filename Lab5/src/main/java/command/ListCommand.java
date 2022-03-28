package command;

import catalog.Catalog;
import item.Item;

/**
 * prints the list of items on the screen
 */
public class ListCommand extends Command {
    public void execute(Catalog catalog) {
        for(Item item: catalog.getListOfItems()){
            System.out.println(item);
        }
        System.out.println();
    }
}
