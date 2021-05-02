import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Connecter {
    private String link;

    public Connecter() {

    }

    public Connecter(String link) {
        this.link = link;
    }

    public String enterLink(){
        Scanner scanner = new Scanner(System.in);
        setLink(scanner.next());
        return link;
    }

    public HttpURLConnection httpURLConnection(String link){
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(link).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.connect();
        } catch (Throwable cause){
            cause.printStackTrace();
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
        return connection;
    }

    public StringBuilder createText(HttpURLConnection connection) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()){

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = in.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

        } else {
            System.out.println("fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
        }
        return stringBuilder;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
