package game;

import frame.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * panel for introducing parameters regarding the grid
 * size and a button for creating a new game
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerForRows;
    JSpinner spinnerForCols;
    JButton createButton = new JButton(("Create"));

    /**
     * constructor for the ConfigPanek
     * @param frame the current frame
     */
    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    /**
     * initialize the configuration panel
     */
    private void init(){

        label = new JLabel("Grid size: ");
        spinnerForRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerForCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        //create spinners for rows and cols, and the button
        //TO DO
        add(label);
        add(spinnerForRows);
        add(spinnerForCols);
        add(createButton);
        createButton.addActionListener(this::createGrid);
    }

    /**
     * create the grid
     * @param e the action event
     */
    private void createGrid(ActionEvent e){
        remove(frame.canvas);
        frame.canvas = new DrawingPanel(frame);
        frame.getContentPane().add(frame.canvas, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * gets the rows from the spinner
     * @return the rows
     */
    public int getRows() {
        return (Integer)spinnerForRows.getValue();
    }
    public int getCols() {
        return (Integer)spinnerForCols.getValue();
    }
}
