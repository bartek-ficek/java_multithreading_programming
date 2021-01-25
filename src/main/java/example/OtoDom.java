package example;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class OtoDom {

    public static void main(String[] args) throws Exception {

        String urlContent = saveUrlContent("https://www.otodom.pl/sprzedaz/mieszkanie/krakow/");
        Set<String> setOfFlatOffers = saveUrlLinksToSet(urlContent, "Offer");
        writeSetOfLinksToFiles(setOfFlatOffers);
    }

    public static String saveUrlContent(String link) throws IOException {
        URL myUrl = new URL(link);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(myUrl.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    public static Set<String> saveUrlLinksToSet(String urlContent, String filename) throws IOException {

        Set<String> setOfLinks = new HashSet<>();
        for (int i = 0; i < urlContent.length(); i++) {
            i = urlContent.indexOf("https://www.otodom.pl/pl/oferta/", i);
            if (i < 0) {
                break;
            }
            String resultLink = urlContent.substring(i).split(".html")[0];
            setOfLinks.add(resultLink);
        }
        System.out.println(setOfLinks.size());
        return setOfLinks;
    }

    public static void writeSetOfLinksToFiles(Set<String> setOfLinks) throws IOException {
        int number = 1;
        for (String link : setOfLinks) {
            writeLinkToFile("Offer-" + number + ".html", link);
            number++;
        }
    }


    private static void writeLinkToFile(String filename, String link) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, false))) {
            bufferedWriter.write(link);
        }
    }
}
