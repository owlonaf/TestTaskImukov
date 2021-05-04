import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Cleaner {
    private HashMap<String, Integer> list;

    public Cleaner(HashMap<String, Integer> list) {
        this.list = list;
    }

    public void clean(){
        System.out.println("If you want to delete any word from the list - type this line, else press enter");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String finish = "end";
        while (input != finish) {
            input = scanner.next();
            if (list.containsKey(input) == false) {
                System.out.println("You've printed the wrong word\nIf you want to end programm working, please, type word 'end'");
                System.out.println(input);
            } else {
                list.remove(input);
                System.out.println("You've deleted the '" + input + "' word\nIf you want to end programm working, please, type word 'end'");
            }
        }
    }
}
