import javax.swing.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init(){
        // create the label and the spinner
        label = new JLabel("Grid size: ");
        spinner = new JSpinner(new SpinnerNumberModel(10,2,100,1));

        // create spinners for rows and cols and the button
        // TO DO

        add(label);
        add(spinner);
    }

}
