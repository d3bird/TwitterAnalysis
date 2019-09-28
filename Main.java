package twitter;

import org.jfree.ui.RefineryUtilities;

public class Main {

	
	public static void main(String[] args) {
		
		TwitterSite twitter = new TwitterSite();
		
		twitter.getTweets("burger");
		
		twitter.printTweetStorage();
		System.out.println("");
		System.out.println("");
		//twitter.getTrends();
	
		

		
		Graphs demo = new Graphs( "Mobile Sales" );  
	      demo.setSize( 800 , 650 );    
	      RefineryUtilities.centerFrameOnScreen( demo );    
	      demo.setVisible( true ); 
		
		
	}

}
