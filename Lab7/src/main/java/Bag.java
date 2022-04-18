import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Bag {
    private Map<Tile, Integer> bagOfTiles;
    private int numberOfTiles = 0;
    private static final int TILES_PER_LETTER = 10;

    public Bag() {
        bagOfTiles = new HashMap<>();
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

        for (Map.Entry<Tile, Integer> entry : bagOfTiles.entrySet()) {
            Tile key = entry.getKey();
            Integer value = entry.getValue();
            numberOfTiles += value;
        }

        System.out.println("HERE IS THE BAG OF TILES" + bagOfTiles);
        System.out.println("nr of tiles" + numberOfTiles);
        System.out.println();


        numberOfTiles = 0;
        bagOfTiles = new HashMap<>();
        for (char c = 'a'; c < 'z'; c++) {
            bagOfTiles.put(new Tile(c, RandomGenerator.getRandomNumber(1,11)), TILES_PER_LETTER);
            numberOfTiles += TILES_PER_LETTER;
        }
        System.out.println("HERE IS THE BAG OF TILES" + bagOfTiles);
        System.out.println(numberOfTiles);
    }

    public Bag(Map<Tile, Integer> bagOfTiles){
        this.bagOfTiles = new HashMap<>(bagOfTiles);
        numberOfTiles = bagOfTiles.size();
    }

    static Map<Tile, Integer> initializeBagOfTiles(){
        Map<Tile, Integer> bagOfTiles = new HashMap<>();
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

    public Map<Tile, Integer> getBagOfTiles() {
        return bagOfTiles;
    }

    public void setBagOfTiles(Map<Tile, Integer> bagOfTiles) {
        this.bagOfTiles = bagOfTiles;
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public void setNumberOfTiles(int numberOfTiles) {
        this.numberOfTiles = numberOfTiles;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Tile checkForCharacterInBag(char character) {
        if (numberOfTiles == 0) {
            return null;
        }
        for (Map.Entry<Tile, Integer> entry : bagOfTiles.entrySet()) {
            Tile tile = entry.getKey();
            if (tile.getLetter() == character) {
                return bagOfTiles.get(tile) != 0 ? tile : null;
            }
        }
        return null;
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        if (bagOfTiles.isEmpty()) {
            return extracted;
        }
        if (numberOfTiles <= howMany) {
            howMany = numberOfTiles;
        }
        for (int i = 0; i < howMany; i++) {
            while (numberOfTiles != 0) {
                // generate a random character from the english alphabet
                char random = (char) getRandomNumber(0, 26);
                char str = Character.toString(97 + random).charAt(0);
                // check that the character is in the bag
                Tile tileTemp = checkForCharacterInBag(str);
                if(tileTemp != null){
                    extracted.add(tileTemp);
                    bagOfTiles.replace(tileTemp, bagOfTiles.get(tileTemp) - 1);
                    numberOfTiles--;
                    break;
                }
            }
        }
        System.out.println("Bag, extracted tiles:" + extracted);
        return extracted;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagOfTiles=" + bagOfTiles +
                ", numberOfTiles=" + numberOfTiles +
                '}';
    }
}