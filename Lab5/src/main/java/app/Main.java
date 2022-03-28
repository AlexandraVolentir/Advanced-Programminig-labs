package app;

import catalog.*;
import catalog.CatalogUtil;
import command.InfoCommand;
import command.ListCommand;
import exceptions.InvalidCatalogException;
import item.BookItem;
import item.MiscItem;
import org.apache.tika.exception.TikaException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import java.io.IOException;

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
        } catch (IOException | ParseException | InvalidCatalogException e) {
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

//        command.ViewCommand viewCommand = new command.ViewCommand();
//        try{
//            viewCommand.execute(item2);
//            viewCommand.execute(item1);
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }

//        command.command.ReportCommand reportCommand = new command.command.ReportCommand();
//        try{
//            reportCommand.execute(catalog1, "/");
//        } catch (IOException | TemplateException e) {
//            e.printStackTrace();
//        }

        System.out.println("Apache Tika in order to extract metadata from the catalog with command.InfoCommand class:\n");
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
