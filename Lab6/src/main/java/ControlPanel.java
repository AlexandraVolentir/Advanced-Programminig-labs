import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBin = new JButton("Exit");
    // create all buttons (Load, Exit, etc.)
    // TO DO

    public ControlPanel(MainFrame frame){
        this.frame = frame;
    }

    private void init(){
        // change the default layout manager (just for fun)
        setLayout(new GridLayout(1,4));

        // add all buttons ... TO DO

        // configure listeners for all buttons
        exitBin.addActionListener(this::exitGame);
    }

    private void exitGame(ActionEvent e){
        frame.dispose();
    }


}
