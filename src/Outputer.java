import java.util.HashMap;
import java.util.Map;

public class Outputer {
    private HashMap<String, Integer> countOfWords;

    public Outputer(HashMap<String, Integer> countOfWords) {
        this.countOfWords = countOfWords;
    }

    public void countOfWordsOut(){
        System.out.println("Count of words:\n");
        for (Map.Entry entry: this.countOfWords.entrySet()) {

            System.out.println(entry);

        }
    }
}
