package twitter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

	public static void main(String[] args) {

		String baseline = "https://twitter.com/search?q=%23";

		String hashtagword = "burger";

		Tweet example = new Tweet();
		Tweet example2 = new Tweet("message",true, 2);//message, does it have pictures, how many
		
		try {
			Document doc = Jsoup.connect(baseline + hashtagword).get();
			System.out.println(doc.title());

			Elements paragraphs = doc.getElementsByTag("p");
			for (Element paragraph : paragraphs) {
				if (paragraph.text().contains(" ")) {
					System.out.println(paragraph.text());
					// System.out.println("");
					System.out.println("");
					System.out.println("");
				}
			}

			System.out.println("");

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}

	}

}
