package twitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class TweetProc implements Runnable {

	private String threadName;

	Vector<String> bad = new Vector<String>();
	Vector<String> good = new Vector<String>();

	Vector<Tweet> dataset;
	boolean newdata;

	Vector<String> comphrase = new Vector<String>();
	Vector comphrasenum = new Vector();

	double[] data;

	public TweetProc(Vector<Tweet> i, String tn) {
		// TODO Auto-generated constructor stub
		dataset = i;
		newdata = false;
		threadName = tn;
		
		importWords("good.txt", true);
		importWords("bad.txt", false);
		
		data  = new double[3];
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
			scanner = new Scanner(new File(file + filename));
			scanner.useDelimiter("\n");

			while (scanner.hasNextLine()) {
				// System.out.println(scanner.nextLine());
				if (g) {
					good.add(scanner.nextLine());
				} else {
					bad.add(scanner.nextLine());
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Couldnot open file");
			e.printStackTrace();
		}
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

	public void run() {
		System.out.println("Running " + threadName);
		boolean found = false;
		if (threadName.equals("good")) {
			for (int i = 0; i < dataset.size(); i++) {
				found = false;
				for (int q = 0; q < good.size(); q++) {
					if (dataset.get(i).getMsg().contains(good.get(q))) {
						data[0]++;
						found = true;
						break;
					}
				}
				if (!found) {
					data[2]++;
				}
			}
		} else {
			for (int i = 0; i < dataset.size(); i++) {
				found = false;
				for (int q = 0; q < bad.size(); q++) {
					if (dataset.get(i).getMsg().contains(bad.get(q))) {
						data[1]++;
						found = true;
						break;
					}
				}
				if (!found) {
					data[2]++;
				}
			}
		}
		
		System.out.println("Thread " + threadName + " exiting.");
	}

	public double[] getStats() {
		// double[] output = { 0, 0, 0 };
	//	System.out.println(data[0]);
	//	System.out.println(data[1]);
		//System.out.println(data[2]);
		return data;
	}

}
