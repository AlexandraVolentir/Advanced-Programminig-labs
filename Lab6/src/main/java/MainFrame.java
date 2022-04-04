import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame
{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("My drawing app");
        init();
    }
    private void init(){
        setTitle("My game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);


        setResizable(false);

        //create the components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        //TO DO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default

        //add(canvas, CENTER);
        add(configPanel, CENTER);
        //add(controlPanel, CENTER);
        //TO DO

        //invoke the layout manager
        pack();
    }
}
