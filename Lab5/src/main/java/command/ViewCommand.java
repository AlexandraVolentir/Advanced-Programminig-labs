package command;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import exceptions.InvalidFileOrURLForView;
import item.*;

public class ViewCommand {
    public void execute(Item item) throws IOException, URISyntaxException, InvalidFileOrURLForView {
        String location = item.getLocation();
        Desktop desktop = Desktop.getDesktop();
        String s = location.trim().toLowerCase();
        File myFile = new File(location);
        boolean isWeb = s.startsWith("http://") || s.startsWith("https://");
        if(isWeb){
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(location));
            }
        }
        else if(Files.isRegularFile(Path.of(location)))
        {
            desktop.open(myFile);
        }
        else {
            throw new InvalidFileOrURLForView(location);
        }
    }
}
