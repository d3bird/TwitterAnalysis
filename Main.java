package twitter;

import java.util.Scanner;
import java.util.Vector;

import org.jfree.ui.RefineryUtilities;

public class Main {

	
	
	
	public static void main(String[] args) throws InterruptedException {

		boolean running = true;
		Scanner input = new Scanner(System.in);
		String in;
		Vector<Twitter> searchs = new Vector<Twitter>();
		Vector<Thread> searchsthreads = new Vector<Thread>();
		
		while (running) {
			System.out.println("enter hashtag to search");
			in = input.next();
			System.out.println(in);
			if(in.equals("end")) {
				running = false;
			}else {
				searchs.add(new Twitter(in));
			}
		}
		
		for(int i =0; i <searchs.size();i++) {
			searchsthreads.add(new Thread(searchs.get(i)));
		}
		for(int i =0; i <searchsthreads.size();i++) {
			searchsthreads.get(i).start();
		}
	}

}
