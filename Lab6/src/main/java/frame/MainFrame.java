package frame;

import game.ConfigPanel;
import game.ControlPanel;
import game.DrawingPanel;

import javax.swing.*;

import java.awt.*;

/**
 * app.Main Frane of the aplication
 */
public class MainFrame extends JFrame
{
    public ConfigPanel configPanel;
    ControlPanel controlPanel;
    public DrawingPanel canvas;

    /**
     * constructor for the app.Main Frame
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
