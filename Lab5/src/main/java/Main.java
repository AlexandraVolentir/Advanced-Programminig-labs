
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
        catalogUtil.save(catalog1, "catalog.json");
        Catalog catalog2 = catalogUtil.load("catalog.json");
        System.out.println("NEW");
        System.out.println(catalog2);

    }
    public static void main(String[] args) {
       compulsory();
    }
}
