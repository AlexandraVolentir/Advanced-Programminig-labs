import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

/**
 * Main Frane of the aplication
 */
public class MainFrame extends JFrame
{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    /**
     * constructor for the Main Frame
     */
    public MainFrame(){
        super("My drawing app");
        init();
    }

    /**
     * initiates the game
     */
    private void init(){
        setTitle("My game");
        setLayout(new BorderLayout(10, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);


        //create the components

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);


        getContentPane().add(configPanel,BorderLayout.NORTH);
        getContentPane().add(canvas, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
        pack();
    }
}
