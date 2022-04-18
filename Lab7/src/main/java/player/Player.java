package player;

import app.Game;
import elements.Tile;
import utilities.MockDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the player which interracts with the game
 */
public class Player {
    private String name;
    private Game game;
    private boolean running;
    static Map<Player, Integer> score = new HashMap<>();
    int pointsAccumulated = 0;

    /**
     * constructor for the player
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * getter for the accumulated points
     * @return gets the accumulated points
     */
    public int getPointsAccumulated() {
        return pointsAccumulated;
    }

    public void setPointsAccumulated(int pointsAccumulated) {
        this.pointsAccumulated = pointsAccumulated;
    }

    /**
     * getter for the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public static Map<Player, Integer> getScore() {
        return score;
    }

    public static void setScore(Map<Player, Integer> score) {
        Player.score = score;
    }

    /**
     * calculated the total points won for the given word
     * @param word the word
     * @return the number of points cumulated
     */
    public int getWordValue(String word){
        int wordValue = 0;
        for (Map.Entry<Tile, Integer> entry : game.getBag().getBagOfTiles().entrySet()) {
            for (int i = 0; i < word.length(); i++) {
                Tile tile = entry.getKey();
                if (tile.getLetter() == word.charAt(i)) {
                    wordValue += game.getBag().getBagOfTiles().get(tile);
                }
            }
        }
        return wordValue;
    }

    /**
     * function for submitting the word
     * it submits the word to the board and calculates the points
     * @return true if the word was submitted, false if the word wasn't submitted
     */
    public boolean submitWord(){
        List<Tile> extracted = game.getBag().extractTiles(7);
        if(extracted.isEmpty()){
            return false;
        }
        StringBuilder word = new StringBuilder();

        // create a word with all the extracted tiles
        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }

        if(MockDictionary.isWord(word.toString())){
            game.getBoard().addWord(this, word.toString());
            pointsAccumulated += getWordValue(word.toString());
            // make the player sleep 50 ms

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /**
     * is the function which is called from the thread
     * it automatically submits the words for the players
     * and also keeps track of who is the winner
     */
    public void run(){
        running = true;
        boolean flag = submitWord();
        while(flag){
            flag = submitWord();
        }
        System.out.println(getName() + " accumulated " + getPointsAccumulated());
        score.put(this, getPointsAccumulated());
        running = false;

        // get the winner of the game
        if(Player.getScore().size() == 3){
            int max = 0;
            String winner = "";
            for (Map.Entry<Player, Integer> entry : Player.getScore().entrySet()) {
                Player key = entry.getKey();
                Integer value = entry.getValue();
                if(value > max){
                    winner = key.getName();
                    max = value;
                }
            }
            System.out.println("The winner is the player " + winner + " with the score " + max);
        }
    }
}
