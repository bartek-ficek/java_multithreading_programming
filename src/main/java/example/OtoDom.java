package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class OtoDom {

    public static void main(String[] args) throws Exception {

        //TODO to check with multiple Threads 59:20

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

            Set<String> setOfLinks = new HashSet<>();
            String websiteContent = stringBuilder.toString();

            for (int i = 0; i < websiteContent.length(); i++) {
                i = websiteContent.indexOf("https://www.otodom.pl/pl/oferta/",i);
                if (i < 0) {
                    break;
                }
                String resultLink = websiteContent.substring(i).split(".html")[0];
                setOfLinks.add(resultLink);
            }
            System.out.println(setOfLinks);
            System.out.println(setOfLinks.size());

        }
    }
}
