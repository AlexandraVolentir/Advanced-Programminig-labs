package app;

import elements.Bag;
import elements.Board;
import elements.Tile;
import player.Player;
import utilities.Dictionary;
import utilities.MockDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * The main code of the application
 */
public class Game {
    private Bag bag;
    private final Board board = new Board();
    private final MockDictionary dictionary= new MockDictionary();
    private List<Player> players = new ArrayList<>();

    /**
     * Constructor for the game
     */
    public Game(){
        bag = new Bag();
    }

    /**
     * adds a player to the game
     * @param player the player
     */
    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    /**
     * starts the thread for each player
     */
    public void play(){
//        utilities.Dictionary.DaemonThread t1 = new utilities.Dictionary.DaemonThread("t1");
//        t1.setDaemon(true);
//        t1.start();
        for(Player player : players){
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    player.run();
                }
            });
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    static void homework(){
        utilities.Dictionary dictionary = new Dictionary(1000);
        System.out.println("Words with given prefix");
        dictionary.lookup("M");
        Game game = new Game();
        game.addPlayer(new Player("player.Player 1"));
        game.addPlayer(new Player("player.Player 2"));
        game.addPlayer(new Player("player.Player 3"));
        game.play();
    }

    static void compulsory(){
        Game game = new Game();
        game.addPlayer(new Player("player.Player 1"));
        game.addPlayer(new Player("player.Player 2"));
        game.addPlayer(new Player("player.Player 3"));
        game.play();
    }

    /**
     * the main function
     */
    public static void main(String[] args) {
//        compulsory();
        homework();
    }
}
