import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * class for canvas (drawing panel) - for drawing the board
 * draws the grid lines according to the values specified in the config panel
 */
public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows;
    int cols;
    int canvasWidth = 600;
    int canvasHeight = 500;
    int boardWidth;
    int boardHeight;
    int cellWidth;
    int cellHeight;
    int padX;
    int padY;
    int stoneSize = 20;
    boolean onClick = false;
    int stoneX;
    int stoneY;
    boolean firstPlayerMove = false;
    Map<Point, Integer> nodes = new HashMap<>();
    Set<Integer> usedNodes = new HashSet<>();
    BufferedImage image; //the offscreen image
    Graphics2D offscreen;

    /**
     * loads the image
     * @param image the image
     */
    void loadImage(BufferedImage image) {
        this.image = image;
        offscreen = image.createGraphics();
        repaint();
    }

    /**
     * Constructor for Drawing
     * @param frame the frame
     */
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    /**
     * creates the offscreen image
     */
    private void createOffscreenImage() {
        image = new BufferedImage(
                canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        repaint();
    }

    /**
     * initializes the drawing panel
     * @param rows the number of rows
     * @param cols the number of columns
     */
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
        paintGrid();
        paintSticks();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
                revalidate();
                repaint();
            }
        });

    }

    /**
     * gets the Shape color
     * @return returns the color (either red or blue)
     */
    private Color getShapeColor() {
        if (!onClick) {
            onClick = true;
            return Color.red;
        }
        else {
            onClick = false;
            return Color.blue;
        }
    }

    /**
     * we verify if the click is in good position
     * @param x the coordinate x
     * @param y the coordinate y
     */
    private void drawStone(int x, int y) {
        boolean validNode = false;
        for(Map.Entry<Point, Integer> entry : nodes.entrySet()) {
            Point point = entry.getKey();
            Integer name = entry.getValue();
            if(x < point.x + 10 && x > point.x - 10) {
                if(y < point.y + 10 && y > point.y - 10) {
                    stoneX = point.x;
                    stoneY = point.y;
                    usedNodes.add(name);
                    validNode = true;
                    firstPlayerMove = true;
                    break;
                }
            }
        }
        if(validNode) {
            paintStones();
        }
    }

    /**
     * prints the grid
     */
    private void paintGrid() {
        offscreen.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++){
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    /**
     * paints the stones and fixes the coordinates
     */
    private void paintStones() {
        offscreen.setColor(getShapeColor());
        offscreen.drawOval(stoneX - stoneSize / 2, stoneY - stoneSize / 2, stoneSize, stoneSize);
        offscreen.fillOval(stoneX - stoneSize / 2, stoneY - stoneSize / 2, stoneSize, stoneSize);
    }

    /**
     * paints the sticks using offscreen
     */
    private void paintSticks() {
        offscreen.setColor(Color.BLACK);
        offscreen.setStroke(new BasicStroke(5));
        Random rand = new Random();

        //horizontal sticks
        int nodeNumber = 1;
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols - 1; col++) {
                int x1 = padX + col * cellWidth;
                int y1 = padY + row * cellHeight;
                int x2 = padX + (col + 1) * cellWidth;
                int y2 = y1;
                if (rand.nextInt(10) % 2 == 1) {
                    offscreen.drawLine(x1, y1, x2, y2);
                    if(!nodes.containsKey(new Point(x1, y1)))
                    {
                        nodes.put(new Point(x1, y1), nodeNumber);
                    }
                    nodeNumber++;
                    if(!nodes.containsKey(new Point(x2, y2)))
                    {
                        nodes.put(new Point(x2, y2), nodeNumber);
                    }
                    nodeNumber++;
                }
            }

        //vertical sticks
        for (int row = 0; row < rows - 1; row++)
            for (int col = 0; col < cols; col++) {
                int x1 = padX + col * cellWidth;
                int y1 = padY + row * cellHeight;
                int x2 = x1;
                int y2 = padY + (row + 1) * cellHeight;
                if (rand.nextInt(10) % 2 == 0) {
                    offscreen.drawLine(x1, y1, x2, y2);
                    if(!nodes.containsKey(new Point(x1, y1)))
                    {
                        nodes.put(new Point(x1, y1), nodeNumber);
                    }
                    nodeNumber++;
                    if(!nodes.containsKey(new Point(x2, y2)))
                    {
                        nodes.put(new Point(x2, y2), nodeNumber);
                    }
                    nodeNumber++;
                }
            }

    }
    @Override
    public void update(Graphics g) { }

    /**
     * uses the function drawImage to paint the component
     * @param graphics the Graphics object
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
