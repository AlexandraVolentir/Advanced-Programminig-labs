import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // create the components
        canvas = new DrawingPanel(this);
        
        // arrange the components in the container(frame)
        // JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER);
        pack();
    }

    private void add(DrawingPanel canvas, String center) {
    }

    // invoke the layout manager

    public static void main(String[] args) {
        System.out.println("Hellli");
    }
}
