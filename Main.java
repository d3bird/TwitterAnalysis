package twitter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String baseline = "https://twitter.com/search?q=%23";

		String hashtagword = "burger";

		try {
			Document doc = Jsoup.connect(baseline + hashtagword).get();
			System.out.println(doc.title());

			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}

	}

}
