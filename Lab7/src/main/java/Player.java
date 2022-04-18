import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private Game game;
    private boolean running;
    int pointsAccumulated = 0;

    public Player(String name) {
        this.name = name;
    }

    public int getPointsAccumulated() {
        return pointsAccumulated;
    }

    public void setPointsAccumulated(int pointsAccumulated) {
        this.pointsAccumulated = pointsAccumulated;
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

    public boolean submitWord(){
//        System.out.println(getName() + " submited the word");
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
//            System.out.println("player: " + getName() + "SUBMITTED A WORD: " + word.toString());
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
        boolean flag = submitWord();
        while(flag){
            flag = submitWord();
        }
        System.out.println(getName() + " accumulated " + getPointsAccumulated());
        running = false;
    }

}
