import java.util.HashMap;

public class Board {
    private HashMap<Player, String> listOfWords = new HashMap<>();

    public Board(){
        this.listOfWords = new HashMap<>();
    }

    public Board(HashMap<Player, String> listOfWords) {
        this.listOfWords = listOfWords;
    }

    public void addWord(Player player, String word){
        listOfWords.putIfAbsent(player, word);
    }

    @Override
    public String toString(){
        return listOfWords.toString();
    }
}
