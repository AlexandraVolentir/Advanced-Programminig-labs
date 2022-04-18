import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

public class Game {
    private final Bag bag;
    private final Board board = new Board();
    private final MockDictionary dictionary= new MockDictionary();
    private List<Player> players = new ArrayList<>();

    public Game(){
        bag = new Bag();
    }

    public Game(Bag bag){
        this.bag = bag;
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public void play(){
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
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    static Map<Tile, Integer> initializeBagOfTiles(){
        Map<Tile, Integer> bagOfTiles = new HashMap<>();
        bagOfTiles.put(new Tile('A',1), 9);
        bagOfTiles.put(new Tile('B',3), 2);
        bagOfTiles.put(new Tile('C',3), 2);
        bagOfTiles.put(new Tile('D',2), 4);
        bagOfTiles.put(new Tile('E',1), 12);
        bagOfTiles.put(new Tile('F',4), 2);
        bagOfTiles.put(new Tile('G',2), 3);
        bagOfTiles.put(new Tile('H',4), 2);
        bagOfTiles.put(new Tile('I',1), 9);
        bagOfTiles.put(new Tile('J',8), 1);
        bagOfTiles.put(new Tile('K',5), 4);
        bagOfTiles.put(new Tile('L',1), 2);
        bagOfTiles.put(new Tile('M',3), 6);
        bagOfTiles.put(new Tile('N',1), 8);
        bagOfTiles.put(new Tile('O',1), 8);
        bagOfTiles.put(new Tile('P',3), 2);
        bagOfTiles.put(new Tile('Q',10), 1);
        bagOfTiles.put(new Tile('R',1), 6);
        bagOfTiles.put(new Tile('S',1), 4);
        bagOfTiles.put(new Tile('T',1), 6);
        bagOfTiles.put(new Tile('U',1), 4);
        bagOfTiles.put(new Tile('V',4), 2);
        bagOfTiles.put(new Tile('W',4), 2);
        bagOfTiles.put(new Tile('X',8), 1);
        bagOfTiles.put(new Tile('Y',4), 2);
        bagOfTiles.put(new Tile('Z',10), 1);
        return bagOfTiles;
    }

    static void homework(){


        Bag bag = new Bag(initializeBagOfTiles());
//        listOfWords.put()
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    public static void main(String[] args) {
//        compulsory();
        homework();
    }
}
