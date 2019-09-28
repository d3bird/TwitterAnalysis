package twitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class TweetProc {

	Vector<String> bad = new Vector<String>();
	Vector<String> good = new Vector<String>();
	
	Vector<Tweet> dataset;
	boolean newdata;

	Vector<String> comphrase = new Vector<String>();
	Vector comphrasenum = new Vector();

	public TweetProc(Vector<Tweet> i) {
		// TODO Auto-generated constructor stub
		dataset = i;
		newdata = false;
	}

	/*
	 * key words/phrases
	 * 
	 * times that a string is mention
	 * 
	 * 
	 * 
	 */
	
	public void importWords(String filename, boolean g) {
	
		    String file = "src/twitter/";
		    Scanner scanner;
			try {
				scanner = new Scanner(new File(file+filename));
			    scanner.useDelimiter("\n");
				 
			    while (scanner.hasNextLine()) {
			        System.out.println(scanner.nextLine()); 
			    } 
		
			} catch (FileNotFoundException e) {
				System.out.println("Couldnot open file");
				e.printStackTrace();
			}
	}
	
	public void importBadWords() {
		
		
	}
	
	

	public int hits(String target) {
		int output = 0;
		for (int i = 0; i < dataset.size(); i++) {
			if (dataset.get(i).getMsg().contains(target)) {
				output++;
			}

		}
		return output;
	}


	
	public double[] getStats(){
		double[] output = {0, 0,0};
		
		
		
		return output;
	}
	
	
}
