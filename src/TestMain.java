import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class TestMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter the link in this format: \nhttps://www.name.domain\nYour link:");
        Scanner scanner = new Scanner(System.in);
        Connecter connecter = new Connecter(scanner.next());
        Formatter formatter = new Formatter(connecter.createText());
        Outputer outputer = new Outputer(formatter.countingOfStrings());
        outputer.countOfWordsOut();
        Cleaner cleaner = new Cleaner(formatter.countingOfStrings());
        cleaner.clean();
        cleaner.showClearResult();
    }
}
