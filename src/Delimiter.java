import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    public static String clearingJunk(StringBuilder stringBuilder){
        String replace = "";
        String reg = "[a-zA-Z]";
        String fin = stringBuilder.toString();
        Pattern pattern = Pattern.compile(reg);
        Matcher match = pattern.matcher(fin);
        fin = match.replaceAll(replace);
        fin = fin.replaceAll("[^а-яА-Я]", "\n");
        return fin;
    }

    public static String[] separationString(String str){
        String[] subStr;
        String delimeter = "\n+"; // Разделитель
        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
        String[] subStr1;
        subStr1 = subStr;
        for (int i = 0; i < subStr.length; i++){
            subStr1[i] = subStr[i].toLowerCase();
        }
        return subStr1;
    }

    public static HashMap<String, Integer> countingOfStrings(String[] strings){
        HashMap<String, Integer> counterOfWords = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            if (counterOfWords.containsKey(strings[i]) == false){
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

            System.out.println(entry);

        }
    }
}
