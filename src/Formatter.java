import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter {
        private StringBuilder textOfHtml;

        public Formatter(StringBuilder textOfHtml) {
        this.textOfHtml = textOfHtml;
        }

        private String clearingJunk(){
            String replace = "";
            String reg = "[a-zA-Z]";
            String clearText = this.textOfHtml.toString();
            Pattern pattern = Pattern.compile(reg);
            Matcher match = pattern.matcher(clearText);
            clearText = match.replaceAll(replace);
            clearText = clearText.replaceAll("[^а-яА-Я]", "\n");
            return clearText;
        }

        private String[] divisionTextForStrings(){
            String[] strings;
            String delimeter = "\n+"; // Разделитель
            strings = clearingJunk().split(delimeter); // Разделения строки str с помощью метода split()
            return strings;
        }

        private String[] stringToLowerCase(){
            String[] finalStrings = divisionTextForStrings();
            for (int i = 0; i < divisionTextForStrings().length; i++){
                finalStrings[i] = divisionTextForStrings()[i].toLowerCase(); //ПОМЕНЯТЬ НАЗВАНИИЯ ВСЕХ ПЕРЕМЕННЫХ НА ЛОГИЧНЫЕ
            }
            return finalStrings;
        }

        public HashMap<String, Integer> countingOfStrings(){
            HashMap<String, Integer> counterOfWords = new HashMap<>();
            for(int i = 0; i < stringToLowerCase().length; i++) {
                if (counterOfWords.containsKey(stringToLowerCase()[i]) == false){ //ВЫНЕСТИ В ОТДЕЛЬНЫЙ КЛАСС
                    counterOfWords.put(stringToLowerCase()[i], 1);
                } else {
                    int v = counterOfWords.get(stringToLowerCase()[i]);
                    counterOfWords.put(stringToLowerCase()[i], v+1);
                }
            }
            return counterOfWords;
        }


    public StringBuilder getTextOfHtml() {
        return textOfHtml;
    }

    public void setTextOfHtml(StringBuilder textOfHtml) {
        this.textOfHtml = textOfHtml;
    }
}