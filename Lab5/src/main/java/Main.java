
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {

    public static void compulsory(){
        System.out.println("-------COMPULSORY-------");
        BookItem item1 = new BookItem("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "book");
        MiscItem item2 = new MiscItem("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "2021", "James Gosling & others");

        System.out.println(item1);
        System.out.println(item2);

        Catalog catalog1 = new Catalog();
        catalog1.add(item1);
        catalog1.add(item2);
        CatalogUtil catalogUtil = new CatalogUtil();
        try{
            catalogUtil.save(catalog1, "catalog.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Catalog catalog2 = new Catalog();
        try{
            catalog2 = catalogUtil.load("catalog.json");
        } catch (InvalidCatalogException | IOException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("NEW");
        System.out.println(catalog2);

    }
    public static void main(String[] args) {
       compulsory();
    }
}
