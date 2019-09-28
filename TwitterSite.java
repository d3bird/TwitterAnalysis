package twitter;

import java.io.IOException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TwitterSite {

	Vector<Tweet> topTweets = new Vector<Tweet>();
	Vector<Tweet> latestTweets = new Vector<Tweet>();
	Vector<Tweet> newTweets = new Vector<Tweet>();

	Vector<Tweet> videoTweets = new Vector<Tweet>();
	Vector<Tweet> boradcastTweets = new Vector<Tweet>();

	String top = "https://twitter.com/search?q=%23";
	String latest = " https://twitter.com/search?f=tweets&vertical=default&q=%23";
	String news = "https://twitter.com/search?f=news&vertical=default&q=%23";

	String video = "https://twitter.com/search?f=videos&vertical=default&q=%23";
	String boradcast = "https://twitter.com/search?f=broadcasts&vertical=default&q=%23";

	// String UStends = "https://trends24.in/united-states/";
	// String UStrends2 = "https://www.tweeplers.com/hashtags/?cc=US";
	public TwitterSite() {

	}

	/*
	 * public void getTrends() {
	 * 
	 * try { int temp = 0;
	 * 
	 * Document doc = Jsoup.connect(UStrends2).get();
	 * System.out.println(doc.title());
	 * 
	 * Elements paragraphs = doc.getElementsByTag("div"); for (Element paragraph :
	 * paragraphs) { if(temp >=9) { break; }else { temp++; } if
	 * (paragraph.text().contains(" ")) { System.out.println(paragraph.text());
	 * System.out.println(""); System.out.println(""); } }
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * 
	 * System.out.println("could not connect to the website");
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public void getAllTweets(String hashtagword) {
		getTopTweets(hashtagword);
		getLatestTweets(hashtagword);
		getNewsTweets(hashtagword);
		getVideoTweets(hashtagword);
		getBroadcatTweetsTweets(hashtagword);
	}

	public void getTopTweets(String hashtagword) {
		try {

			boolean pics = false;
			String msg = "";
			int nPics = -1;
			Tweet temp;

			Document doc = Jsoup.connect(top + hashtagword).get();
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
						topTweets.add(temp);
					}
					// System.out.println("");
					// System.out.println("");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}

	}

	public void getLatestTweets(String hashtagword) {
		try {

			boolean pics = false;
			String msg = "";
			int nPics = -1;
			Tweet temp;

			Document doc = Jsoup.connect(latest + hashtagword).get();
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
						latestTweets.add(temp);
					}
					// System.out.println("");
					// System.out.println("");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}

	}

	public void getNewsTweets(String hashtagword) {
		try {

			boolean pics = false;
			String msg = "";
			int nPics = -1;
			Tweet temp;

			Document doc = Jsoup.connect(news + hashtagword).get();
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
						newTweets.add(temp);
					}
					// System.out.println("");
					// System.out.println("");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}
	}

	public void getVideoTweets(String hashtagword) {
		try {

			boolean pics = false;
			String msg = "";
			int nPics = -1;
			Tweet temp;

			Document doc = Jsoup.connect(video + hashtagword).get();
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
						videoTweets.add(temp);
					}
					// System.out.println("");
					// System.out.println("");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}
	}

	public void getBroadcatTweetsTweets(String hashtagword) {
		try {

			boolean pics = false;
			String msg = "";
			int nPics = -1;
			Tweet temp;

			Document doc = Jsoup.connect(boradcast + hashtagword).get();
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
						boradcastTweets.add(temp);
					}
					// System.out.println("");
					// System.out.println("");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("could not connect to the website");

			e.printStackTrace();
		}
	}

	public int getNumOfTweets() {
		return (topTweets.size() + latestTweets.size() + newTweets.size() + videoTweets.size()
				+ boradcastTweets.size());
	}

	public Vector<Tweet> getTweets() {
		Vector<Tweet> output = new Vector<Tweet>();
		output.addAll(topTweets);
		output.addAll(latestTweets);
		output.addAll(newTweets);
		output.addAll(videoTweets);
		output.addAll(boradcastTweets);
		return output;
	}

	public void printTweetStorage() {
		Vector<Tweet> output = getTweets();
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i).getMsg());
			System.out.println("");
			System.out.println("");
		}
	}

}
