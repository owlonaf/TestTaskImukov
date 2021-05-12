import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter {
    private StringBuilder textOfHtml;

    public Formatter(StringBuilder textOfHtml) {
        this.textOfHtml = textOfHtml;
    }

    private String clearingJunk() {
        String replace = "";
        String reg = "[a-zA-Z]";
        String clearText = this.textOfHtml.toString();
        Pattern pattern = Pattern.compile(reg);
        Matcher match = pattern.matcher(clearText);
        clearText = match.replaceAll(replace);
        clearText = clearText.replaceAll("[^а-яА-Я]", "\n");
        return clearText;
    }

    public String[] divisionTextForStrings() {
        String[] words;
        String delimeter = "\n+";
        words = clearingJunk().split(delimeter);
        return words;
    }

    public Map<String, Integer> countingOfStrings() {
        Map<String, Integer> counterOfWords = new HashMap<>();
        String[] finalStrings = divisionTextForStrings();

        for (String word : finalStrings) {
            String wordLowerCase = word.toLowerCase();

            if (counterOfWords.containsKey(wordLowerCase) == false) {
                counterOfWords.put(wordLowerCase, 1);
            } else {
                int v = counterOfWords.get(wordLowerCase);
                counterOfWords.put(wordLowerCase, v + 1);
            }
        }
        counterOfWords.remove("");
        return counterOfWords;
    }
}