package command;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import item.*;

public class ViewCommand {
    public void execute(Item item) throws IOException, URISyntaxException {
        String location = item.getLocation();
        Desktop desktop = Desktop.getDesktop();
        String s = location.trim().toLowerCase();
        boolean isWeb = s.startsWith("http://") || s.startsWith("https://");
        if(isWeb){
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(location));
            }
        }
        else
        {
            File myFile = new File(location);
            desktop.open(myFile);
        }
    }
}
