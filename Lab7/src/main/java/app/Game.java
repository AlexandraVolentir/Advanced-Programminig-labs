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

public class Game {
    private Bag bag;
    private final Board board = new Board();
    private final MockDictionary dictionary= new MockDictionary();
    private List<Player> players = new ArrayList<>();

    public Game(){
        bag = new Bag();
    }

    public Game(Bag bag){
//        try {
//            this.bag = new elements.Bag(bag);
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//            System.out.println(" AICI 1");
//        }
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

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

    static void compulsory(){
        Game game = new Game();
        game.addPlayer(new Player("player.Player 1"));
        game.addPlayer(new Player("player.Player 2"));
        game.addPlayer(new Player("player.Player 3"));
        game.play();
    }

    static Map<Tile, Integer> initializeBagOfTiles(){
        Map<Tile, Integer> bagOfTiles = new ConcurrentHashMap<>();
        File f = new File("board.txt");
        Scanner in = null;
        try {
            in = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(" AICI 2");
        }
        while (in.hasNext()) {
            String[] words = in.nextLine().split(" ");
            bagOfTiles.put(new Tile(words[0].charAt(0),Integer.parseInt(words[1])), Integer.parseInt(words[2]));

        }
        for (Map.Entry<Tile, Integer> entry : bagOfTiles.entrySet()) {
            Tile key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " ---- " + value);
        }
        return bagOfTiles;
    }

    static void homework(){
        utilities.Dictionary dictionary = new Dictionary(1000);
        System.out.println("Words with given prefix");
        dictionary.lookup("E");
        Game game = new Game();
        game.addPlayer(new Player("player.Player 1"));
        game.addPlayer(new Player("player.Player 2"));
        game.addPlayer(new Player("player.Player 3"));
        game.play();

    }

    public static void main(String[] args) {
//        compulsory();
        homework();
    }
}
