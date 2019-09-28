package twitter;

import java.util.Vector;

public class Tweet {

	private boolean pictures;
	private int numPics;
	
	private String msg;
	
	private Vector<String> hashtags;
	
	public Tweet() {
		hashtags = new Vector<String>();
		msg = "";
		numPics = -1;
		pictures = false;
	}
	
	public Tweet(String m, boolean b, int pic) {
		hashtags = new Vector<String>();
		msg = m;
		if (!b) {
			numPics = -1;
		}else {
			numPics = pic;
		}
		pictures = b;
	}

	//getters and setters
	public boolean isPictures() {
		return pictures;
	}

	public void setPictures(boolean pictures) {
		this.pictures = pictures;
	}

	public void setMsg(String i) {
		msg = i;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setNumPics(int i) {
		numPics =i;
	}
	
	public int getNumPics() {
		return numPics;
	}
	
	public void addHashTag(String i) {
		hashtags.add(i);
	}
	
	public void removeItem(int i) {
		hashtags.remove(i);
	}

	public Vector<String> getAdditionalHashtags(){
		return hashtags;
	}
	
}
