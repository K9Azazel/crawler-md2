import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.youtube.com/channel/UC2sYZ2idZS0VBwQO53yJCzg/videos");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
// close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("<h3(.*?)<a(.*?)href=(.*?)</a>(.*?)</h3>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(3));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
