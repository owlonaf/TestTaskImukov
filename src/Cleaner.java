import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cleaner {
    private HashMap<String, Integer> list;

    public Cleaner(HashMap<String, Integer> list) {
        this.list = list;
    }

    public void clean(){
        System.out.println("If you want to delete any word from the list - type this line, else type end");
        Scanner scanner = new Scanner(System.in);
        String input = "";
         while (!input.equals("end")){
            input = scanner.next();
            if (input.equals("end")){

            } else {
                if (list.containsKey(input) == false) {
                    System.out.println("You've printed the wrong word\nIf you want to end programm working, please, type word 'end'");
                } else {
                    list.remove(input);
                    System.out.println("You've deleted the '" + input + "' word\nIf you want to end programm working, please, type word 'end'");
                }
            }
        }
    }

    public void showClearResult(){
        System.out.println("Count of words without junk:");

        for (Map.Entry entry: this.list.entrySet()) {

            System.out.println(entry);

        }
    }
}
