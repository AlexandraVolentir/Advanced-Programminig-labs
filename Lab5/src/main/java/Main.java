
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {

    public static void compulsory(){
        BookItem item1 = new BookItem("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "1967", "Donald E. Knuth", "book");
        MiscItem item2 = new MiscItem("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "2021", "James Gosling & others");

        System.out.println(item1);
        System.out.println(item2);

        Catalog catalog = new Catalog();
        catalog.add(item1);
        catalog.add(item2);
        catalog.save();
    }
    public static void main(String[] args) {
       compulsory();
    }
}
