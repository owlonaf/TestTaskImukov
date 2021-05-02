import java.io.IOException;


public class TestMain {
    public static void main(String[] args) throws IOException {
        Connecter connecter = new Connecter();
        connecter.enterLink();
        Delimiter.countOfWordsOut(Delimiter.countingOfStrings(Delimiter.separationString(Delimiter.clearingJunk(connecter.createText(connecter.httpURLConnection(connecter.getLink()))))));
    }
}
