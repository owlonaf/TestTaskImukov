import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TODO: создать класс с методом сохраняющим мапу в файлик на диске
//TODO: сделать бдшку для статистики
public class TestMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter the link in this format: \nhttps://www.name.domain\nYour link:");
        Scanner scanner = new Scanner(System.in);
        String urlInput = scanner.next();

        Connecter connecter = new Connecter(urlInput);
        StringBuilder text = connecter.getText();

        Formatter formatter = new Formatter(text);
        Map<String, Integer> wordCountMap = formatter.countingOfStrings();

        Outputer.countOfWordsOut(wordCountMap);

        Cleaner.clean(wordCountMap);
        Outputer.countOfWordsOut(wordCountMap);
    }
}
