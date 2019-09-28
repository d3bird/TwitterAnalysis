package twitter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String baseline = "https://twitter.com/search?q=%23";

		String hashtagword = "burger";

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
