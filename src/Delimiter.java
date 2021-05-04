import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    public static String clearingJunk(StringBuilder textOfHtml){
        String replace = "";
        String reg = "[a-zA-Z]";
        String clearText = textOfHtml.toString();
        Pattern pattern = Pattern.compile(reg);
        Matcher match = pattern.matcher(clearText);
        clearText = match.replaceAll(replace);
        clearText = clearText.replaceAll("[^а-яА-Я]", "\n");
        return clearText;
    }

    public static String[] divisionTextForStrings(String text){
        String[] strings;
        String delimeter = "\n+"; // Разделитель
        strings = text.split(delimeter); // Разделения строки str с помощью метода split()
        return strings;
    }

    public static String[] stringToLowerCase(String[] notLowerCaseStrings){
        String[] finalStrings = null;
        for (int i = 0; i < notLowerCaseStrings.length; i++){
            finalStrings[i] = notLowerCaseStrings[i].toLowerCase(); //ПОМЕНЯТЬ НАЗВАНИИЯ ВСЕХ ПЕРЕМЕННЫХ НА ЛОГИЧНЫЕ
        }
        return finalStrings;
    }

    public static HashMap<String, Integer> countingOfStrings(String[] strings){
        HashMap<String, Integer> counterOfWords = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            if (counterOfWords.containsKey(strings[i]) == false){ //ВЫНЕСТИ В ОТДЕЛЬНЫЙ КЛАСС
                counterOfWords.put(strings[i], 1);
            } else {
                int v = counterOfWords.get(strings[i]);
                counterOfWords.put(strings[i], v+1);
            }
        }
        return counterOfWords;
    }

    public static void countOfWordsOut(HashMap<String, Integer> hashMap){
        for (Map.Entry entry: hashMap.entrySet()) {

            System.out.println(entry); //ЗАПРИВАТИТЬ ВСЕ МЕТОДЫ И ВЫЗЫВАТЬ ОТСЮДА ТОЛЬКО ОДИН

        }
    }
}
