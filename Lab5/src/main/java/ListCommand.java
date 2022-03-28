import com.sun.security.jgss.GSSUtil;
import jdk.jfr.Configuration;

public class ListCommand {
    public void execute(Catalog catalog) {
        for(Item item: catalog.getListOfItems()){
            System.out.println(item);
        }
        System.out.println();
    }
}
