import java.util.List;

public class Player {
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
    }

    public boolean submitWord(){
        List<Tile> extracted = game.getBag().extractTiles(7);
        if(extracted.isEmpty()){
            return false;
        }
        String word = "";

        // create a word with all the extracted tiles
        game.getBoard().addWord(this, word);

        // make the player sleep 50 ms
        return true;
    }

    // TODO implement the run method
}
