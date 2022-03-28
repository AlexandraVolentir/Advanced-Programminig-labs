import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.parser.txt.TXTParser;


public class InfoCommand {
    public String parseExample(String location) throws IOException, SAXException, TikaException {
        BodyContentHandler bodyContentHandler
                = new BodyContentHandler();
        FileInputStream fileInputStream
                = new FileInputStream(location);
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();
        TXTParser textParser = new TXTParser();
        textParser.parse(fileInputStream, bodyContentHandler, metadata,
                parseContext);
        System.out.println("Contents :"
                + bodyContentHandler.toString());
        return bodyContentHandler.toString();
    }
}
