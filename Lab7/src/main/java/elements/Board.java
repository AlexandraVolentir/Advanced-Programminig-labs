package elements;

import player.Player;

import java.util.HashMap;

/**
 * Class for generating a board where the players will place the tiles
 */
public class Board {
    private HashMap<Player, String> listOfWords;

    /**
     * constructor for Board
     */
    public Board(){
        this.listOfWords = new HashMap<>();
    }

    /**
     * getter fot the list of words
     * @return
     */
    public HashMap<Player, String> getListOfWords() {
        return listOfWords;
    }

    /**
     * setter for the list of words
     * @param listOfWords the returned list of words
     */
    public void setListOfWords(HashMap<Player, String> listOfWords) {
        this.listOfWords = listOfWords;
    }

    /**
     * add words to the list of words
     * @param player the player
     * @param word the word
     */
    public void addWord(Player player, String word){
        listOfWords.putIfAbsent(player, word);
    }

    /**
     * to string function
     * @return the list of words
     */
    @Override
    public String toString(){
        return listOfWords.toString();
    }
}
