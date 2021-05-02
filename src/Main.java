import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String http = scanner.next();

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(http).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);

            connection.connect();

            StringBuilder stringBuilder = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null){
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }

                //System.out.println(stringBuilder.toString());

                String replace = "";
                String reg = "[a-zA-Z]";
                String fin = stringBuilder.toString();
                Pattern pattern = Pattern.compile(reg);
                Matcher match = pattern.matcher(fin);
                fin = match.replaceAll(replace);
                fin = fin.replaceAll("[^а-яА-Я]", "\n");
                //System.out.println(fin);

                String[] subStr;
                String delimeter = "\n+"; // Разделитель
                subStr = fin.split(delimeter); // Разделения строки str с помощью метода split()
                String[] subStr1;
                subStr1 = subStr;
                for (int i = 0; i < subStr.length; i++){
                    subStr1[i] = subStr[i].toLowerCase();
                }

                HashMap<String, Integer> counterOfWords = new HashMap<>();
                for(int i = 0; i < subStr1.length; i++) {
                    if (counterOfWords.containsKey(subStr1[i]) == false){
                        counterOfWords.put(subStr1[i], 1);
                    } else {
                        int v = counterOfWords.get(subStr1[i]);
                        counterOfWords.put(subStr1[i], v+1);
                    }
                }
                counterOfWords.remove("", 1);

                for (Map.Entry entry: counterOfWords.entrySet()) {

                    System.out.println(entry);

                }


            } else {
                System.out.println("fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }
        } catch (Throwable cause){
            cause.printStackTrace();
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
    }
}
