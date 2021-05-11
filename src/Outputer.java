import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Outputer {
    private static FileHandler fileHandler;
    private static Logger log;

    public static void countOfWordsOut(Map<String, Integer> countOfWords) {
        System.out.println("Count of words:\n");
        for (Map.Entry entry : countOfWords.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void saveInFile(Map<String, Integer> mapWithWords) throws IOException {
        try(FileWriter writer = new FileWriter("CountOfWords.txt", false)){
            for (String key : mapWithWords.keySet()){
                writer.write(key + " : " + mapWithWords.get(key) +"\n");
                writer.flush();
            }
        } catch (Exception e){
            fileHandler = new FileHandler("C:/Users/1/IdeaProjects/TestTask/logs/outputLog.log");
            log.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            e.printStackTrace();
            log.log(Level.WARNING, "Error is happened at the Outputer", e);
        }
    }
}
