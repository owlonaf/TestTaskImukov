import java.util.HashMap;
import java.util.Map;

public class Outputer {
    private HashMap<String, Integer> countOfWords;

    public Outputer(HashMap<String, Integer> countOfWords) {
        this.countOfWords = countOfWords;
    }

    public void countOfWordsOut(){
        for (Map.Entry entry: this.countOfWords.entrySet()) {

            System.out.println(entry); //ЗАПРИВАТИТЬ ВСЕ МЕТОДЫ И ВЫЗЫВАТЬ ОТСЮДА ТОЛЬКО ОДИН

        }
    }
}
