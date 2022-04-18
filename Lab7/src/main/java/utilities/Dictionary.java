package utilities;

import com.github.javafaker.Faker;
import me.shib.java.lib.diction.DictionService;
import me.shib.java.lib.diction.DictionWord;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary(int nrOfWords) {
        dictionary = new HashMap<>();
        try {
            createDictionary(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void createDictionary(int nrOfWords) throws IOException {
        FileWriter fw = new FileWriter("dictionary.txt");
        int counter = 0;
        while (counter < nrOfWords) {
            Faker faker = new Faker();
            String randomWord = faker.address().country();
            DictionService dictionService = new DictionService();

            // Search for a word in the dictionary
            DictionWord word = dictionService.getDictionWord(randomWord);
            if (word == null || dictionary.containsKey(word.getWord())) {
                return;
            }
            counter++;
            StringBuilder generalDescription = new StringBuilder();
            List<DictionWord.DictionDesc> descriptions = word.getDescriptions();
            String wordDescription = "";
            for (DictionWord.DictionDesc description : descriptions) {
                wordDescription = description.getWordType() + "- " + description.getDescription();
                generalDescription.append(description);
            }

            dictionary.put(word.getWord(), wordDescription);
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
//                fw.write(key + " " + value);
//                fw.write("\n");
                System.out.println(key + " " + value);
            }
            fw.close();
        }
    }

        public void lookup(String prefix){
            List<String> yourList = new ArrayList<>(dictionary.keySet());
            final List<String> filteredList = yourList.parallelStream()
                    .filter(s -> s.startsWith(prefix))
                    .collect(Collectors.toList());
            System.out.println(filteredList);
        }

}