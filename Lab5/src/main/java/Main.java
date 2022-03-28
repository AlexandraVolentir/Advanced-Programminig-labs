
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.json.simple.parser.ParseException;
import freemarker.template.Configuration;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        System.out.println("The NEW catalog after reading from the file:");
        System.out.println(catalog2);
        System.out.println("\n");
    }

    public static void homework(){
        System.out.println("------HOMEWORK-------");
        BookItem item1 = new BookItem("knuth67", "The Art of Computer Programming", "bookExample.txt", "1967", "Donald E. Knuth", "book");
        MiscItem item2 = new MiscItem("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "2021", "James Gosling & others");
        Catalog catalog1 = new Catalog();
        catalog1.add(item1);
        catalog1.add(item2);

        System.out.println("Listed items of the catalog with the ListItem class:\n");
        ListCommand listCommand = new ListCommand();
        listCommand.execute(catalog1);

//        ViewCommand viewCommand = new ViewCommand();
//        try{
//            viewCommand.execute(item2);
//            viewCommand.execute(item1);
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }

//        ReportCommand reportCommand = new ReportCommand();
//        try{
//            reportCommand.execute(catalog1, "/");
//        } catch (IOException | TemplateException e) {
//            e.printStackTrace();
//        }

        System.out.println("Apache Tika in order to extract metadata from the catalog with InfoCommand class:\n");
        InfoCommand infoCommand = new InfoCommand();
        try {
            infoCommand.parseExample("catalog.json");
        } catch (IOException | SAXException | TikaException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
       compulsory();
       homework();
    }
}
