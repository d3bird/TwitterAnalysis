package twitter;

import org.jfree.ui.RefineryUtilities;

public class Main {

	public static void main(String[] args) {

		TwitterSite twitter = new TwitterSite();

		twitter.getAllTweets("mcdonalds");

		System.out.println(twitter.getNumOfTweets());

		Graphs demo = new Graphs("Twitter stats", 30, 40, 1);
		demo.setSize(800, 650);
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);

	}

}
