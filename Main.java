package twitter;

public class Main {

	
	public static void main(String[] args) {
		
		TwitterSite twitter = new TwitterSite();
		
		twitter.getTweets("burger");
		
		twitter.printTweetStorage();

	}

}
