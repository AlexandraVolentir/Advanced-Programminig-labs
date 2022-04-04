import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Panel for managing the game
 * This panel will contain the buttons: Load, Save, Exit
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");

    /**
     * Constructor for the control panel
     * @param frame the frame
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * initialize the control panel
     */
    private void init(){
        add(exitBtn);
        add(loadButton);
        add(saveButton);

        exitBtn.addActionListener(this::exitGame);
        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);
    }

    /**
     * action for exiting the game
     * @param e actionEvent
     */
    private void exitGame(ActionEvent e){
        frame.dispose();
    }

    /**
     * function for loading the game
     * @param event the action event
     */
    private void loadGame(ActionEvent event) {
        BufferedImage image = null;
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Select an image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG images", "png");
            fileChooser.addChoosableFileFilter(filter);

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                image = ImageIO.read(new File(fileChooser.getSelectedFile().getPath()));
                frame.canvas.loadImage(image);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Save the current state of the canvas
     * using a file chooser
     */
    private void saveGame(ActionEvent event) {
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Choose a directory to save your file");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                ImageIO.write(frame.canvas.image, "PNG",
                        new File(fileChooser.getSelectedFile() + "\\test.png"));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
