package twitter;

import java.io.IOException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TwitterSite {

	Vector<Tweet> tweets = new Vector<Tweet>();
	String baseline = "https://twitter.com/search?q=%23";

	String UStends = "https://trends24.in/united-states/";
	String UStrends2 = "https://www.tweeplers.com/hashtags/?cc=US";
	public TwitterSite() {

	}

	public void getTrends() {

		try {
			int temp = 0;

			Document doc = Jsoup.connect(UStrends2).get();
			System.out.println(doc.title());

			Elements paragraphs = doc.getElementsByTag("div");
			for (Element paragraph : paragraphs) {
				if(temp >=9) {
					break;
				}else {
					temp++;
				}
				if (paragraph.text().contains(" ")) {
					System.out.println(paragraph.text());
					System.out.println("");
					System.out.println("");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}

	}

	public void getTweets(String hashtagword) {

		// Tweet example = new Tweet();
		// Tweet example2 = new Tweet("message",true, 2);//message, does it have
		// pictures, how many

		// retrive the tweets
		try {

			boolean pics = false;
			String msg = "";
			int nPics = -1;
			Tweet temp;

			Document doc = Jsoup.connect(baseline + hashtagword).get();
			System.out.println(doc.title());

			Elements paragraphs = doc.getElementsByTag("p");
			for (Element paragraph : paragraphs) {
				if (paragraph.text().contains(" ")) {

					if (paragraph.text().contains("e've detected that JavaScript")) {
						System.out.println("removed javascript message");
					} else {

						pics = false;
						nPics = -1;
						msg = paragraph.text();

						if (msg.contains("pic.twitter.com/")) {
							pics = true;
							nPics = 1;
						}

						temp = new Tweet(msg, pics, nPics);
						// System.out.println(temp.getMsg());
						tweets.add(temp);
					}
					// System.out.println("");
					// System.out.println("");
				}
			}

			System.out.println("printing out from data storage");

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}

	}

	public void getTopHashTags() {

	}
	
	
	public int getNumOfTweets() {
		return tweets.size();
	}

	public Vector<Tweet> getTweets() {
		return tweets;
	}

	public void printTweetStorage() {
		for (int i = 0; i < tweets.size(); i++) {
			System.out.println(tweets.get(i).getMsg());
			System.out.println("");
			System.out.println("");
		}
	}

}
