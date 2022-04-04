import javax.swing.*;

import java.awt.*;

import static sun.tools.jconsole.OutputViewer.init;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JPanel panel;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }
    private void init(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.DARK_GRAY);

        label = new JLabel("Grid size: ");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        panel.add(label);
        panel.add(spinner);
        //create spinners for rows and cols, and the button
        //TO DO
        frame.add(panel, BorderLayout.CENTER);
    }
}
