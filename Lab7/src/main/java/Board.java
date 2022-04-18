import java.util.HashMap;

public class Board {
    private HashMap<Player, String> listOfWords;

    public Board(){
        this.listOfWords = new HashMap<>();
    }

    public HashMap<Player, String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(HashMap<Player, String> listOfWords) {
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
