package twitter;

import org.jfree.ui.RefineryUtilities;

public class Twitter implements Runnable {

	String input;
	
	public Twitter(String i) {
		 input =i;
		// TODO Auto-generated constructor stub
	}

	public void run() {
		
		TwitterSite twitter = new TwitterSite();
		
		twitter.getAllTweets(input);

		System.out.println("retrived " +twitter.getNumOfTweets()+ " from "+ input );

				
		TweetProc p1 = new TweetProc(twitter.getTweets(), "bad");
		TweetProc p2 = new TweetProc(twitter.getTweets(), "good");
		
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double[] temp = p1.getStats();
		double[] temp2 = p2.getStats();
		/*System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		
		System.out.println(temp2[0]);
		System.out.println(temp2[1]);
		System.out.println(temp2[2]);*/

		double p  = temp[0] + temp2[0];
		double n  = temp[1] + temp2[1];
		double neu  = twitter.getNumOfTweets() - (p + n);
		
		
		
		Graphs demo = new Graphs("Twitter stats for " + input, p, n, neu);
		demo.setSize(800, 650);
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
		
	}

}
