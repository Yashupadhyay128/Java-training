package Assignment13;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebPageScraper {
    public static void main(String[] args) {
        String url = "https://www.indiatoday.in/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements headlines = doc.select("h1, h2, h3, h4, h5, h6");
            System.out.println("Headlines:");
            for (Element headline : headlines) {
                System.out.println(headline.text());
            }

            Elements links = doc.select("a[href]");
            System.out.println("\nLinks:");
            for (Element link : links) {
                String linkText = link.text();
                String linkHref = link.attr("href");
                System.out.println(linkText + " - " + linkHref);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
