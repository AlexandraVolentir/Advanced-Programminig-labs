package utilities;

import com.github.javafaker.Faker;
import me.shib.java.lib.diction.DictionService;
import me.shib.java.lib.diction.DictionWord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dictionary {
    private Map < String, String > dictionary;

    public Dictionary(int nrOfWords) {
        dictionary = new HashMap < > ();
        createDictionary(100);
    }

    public Map < String, String > getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map < String, String > dictionary) {
        this.dictionary = dictionary;
    }

    public void createDictionary(int nrOfWords) {
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
            List < DictionWord.DictionDesc > descriptions = word.getDescriptions();
            String wordDescription = "";
            for (DictionWord.DictionDesc description: descriptions) {
                wordDescription = description.getWordType() + "- " + description.getDescription();
                generalDescription.append(description);
            }

            dictionary.put(word.getWord(), wordDescription);
            for (Map.Entry < String, String > entry: dictionary.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + " " + value);
            }
        }
    }
}
