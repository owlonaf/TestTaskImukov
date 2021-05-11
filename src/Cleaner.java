import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Cleaner {

    public static void clean(Map<String, Integer> list) throws IOException {
        System.out.println("If you want to delete any word from the list - type this line, else type end");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("end")) {
            input = scanner.next();
            if (!input.equals("end")) {
                if (!list.containsKey(input)) {
                    System.out.println("You've printed the wrong word\nIf you want to end programm working, please, type word 'end'");
                    Outputer.saveInFile(list);
                } else {
                    list.remove(input);
                    System.out.println("You've deleted the '" + input + "' word\nIf you want to end programm working, please, type word 'end'");
                    Outputer.saveInFile(list);
                }
            } else { Outputer.saveInFile(list); }
        }
    }
}
