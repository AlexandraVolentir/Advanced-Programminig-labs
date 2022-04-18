package elements;

import java.util.HashMap;
import java.util.Map;

/**
 * class that stores the playing tiles with their letter and score
 */
public class Tile {
    private final char letter;
    private final int points;

    static Map<Character, Tile> tile;

    /**
     * class for the tile
     * @param letter the letter
     * @param points the points corresponding to the letter
     */
    public Tile(char letter, int points) {
        tile = new HashMap<>();
        this.letter = letter;
        this.points = points;
        tile.put(letter, this);
    }

    public static Map<Character, Tile> getTile() {
        return tile;
    }

    /**
     * setter for the tile
     * @param tile
     */
    public static void setTile(Map<Character, Tile> tile) {
        Tile.tile = tile;
    }

    /**
     * getter for the tile
     * @return returns the letter
     */
    public char getLetter() {
        return letter;
    }

    /**
     * getter for the number of points
     * @return the number of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * to string function
     * @return returns the concatenated strings
     */
    @Override
    public String toString() {
        return "elements.Tile{" +
                "letter=" + letter +
                ", points=" + points +
                '}';
    }
}
