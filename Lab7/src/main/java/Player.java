import java.util.List;

public class Player {
    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

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
            System.out.println("player: " + getName() + "SUBMITTED A WORD: " + word.toString());
            // make the player sleep 50 ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(" AICI 3 player");
            }
            return true;
        }
        return false;
    }

    public void run(){
        running = true;
        int pointsAccumulated = 0;
        boolean flag = submitWord();
        while(flag){
            flag = submitWord();
        }
        running = false;
    }

}
