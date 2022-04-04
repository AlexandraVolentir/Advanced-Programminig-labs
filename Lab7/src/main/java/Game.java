import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final MockDictionary dictionary= new MockDictionary();
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public void play(){
        for(Player player : players){
            // start a new thread representing the player
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    public Bag getBag() {
        return null;
    }

    public Board getBoard() {
        return null;
    }
}
