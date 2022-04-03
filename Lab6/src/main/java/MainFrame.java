import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("My drawing application");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         // create the components
        canvas = new DrawingPanel(this);
        // TO DO

        // arrange the components in the container (frame)
        // JFRAME uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER);
        // TO DO

        // invoke the layout manager
        pack();


    }

}
