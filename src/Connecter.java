import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Connecter {
    private String link;
    private final String requestMethod = "GET";
    private final Boolean useCaches = false;
    private final int timeout = 3000;
    private static Logger log = Logger.getLogger(Connecter.class.getName());
    private static FileHandler fileHandler;

    public Connecter(String link) {
        this.link = link;
    }

    private HttpURLConnection createConnection() throws IOException {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(this.link).openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setUseCaches(useCaches);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.connect();
        } catch (Throwable cause){
            fileHandler = new FileHandler("C:/Users/1/IdeaProjects/TestTask/logs/conLog.log");
            log.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            cause.printStackTrace();
            log.log(Level.WARNING, "Error is happened at Connecter", cause);
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
        return connection;
    }

    public StringBuilder getText() throws IOException {
        HttpURLConnection connectionForInteraction = createConnection();

        StringBuilder textOfHtml = new StringBuilder();

        if (HttpURLConnection.HTTP_OK == connectionForInteraction.getResponseCode()){

            BufferedReader in = new BufferedReader(new InputStreamReader(connectionForInteraction.getInputStream()));
            String stringOfHtml;

            while ((stringOfHtml = in.readLine()) != null){
                textOfHtml.append(stringOfHtml);
                textOfHtml.append("\n");
            }
        } else {
            System.out.println("fail: " + connectionForInteraction.getResponseCode() + ", " + connectionForInteraction.getResponseMessage());
        }
        return textOfHtml;
    }
}
