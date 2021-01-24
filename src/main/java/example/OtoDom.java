package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class OtoDom {

    public static void main(String[] args) throws Exception {

        URL myUrl = new URL("https://www.otodom.pl/sprzedaz/mieszkanie/krakow/");
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(myUrl.openStream()))) {

            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                stringBuilder.append(System.lineSeparator());
            }
            in.close();

            String websiteContent = stringBuilder.toString();
            int linkIndex = websiteContent.indexOf("https://www.otodom.pl/pl/oferta/");

            String linkStart = websiteContent.substring(linkIndex);
            String resultLink = (linkStart.split(".html"))[0];
            System.out.println(resultLink);
        }
    }
}
