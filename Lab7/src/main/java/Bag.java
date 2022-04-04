import java.util.ArrayList;
import java.util.List;

public class Bag {
    private ArrayList<Tile> arrayList;
    public Bag() {
        arrayList = new ArrayList<>();
        for (char c = 'a'; c < 'z'; c++) {
            arrayList.add(new Tile(c, c));
        }
    }

        public synchronized List<Tile> extractTiles(int howMany){
            List<Tile> extracted = new ArrayList<>();
            for(int i = 0; i < howMany; i++){
                if(arrayList.isEmpty()){
                    break;
                }
                extracted.add(arrayList.get(i));
            }
            return extracted;
        }
    }

