package review;

public class WordCloudBean {
	String hashtag;
	int frequency;
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public WordCloudBean(String hashtag, int frequency) {
		super();
		this.hashtag = hashtag;
		this.frequency = frequency;
	}
	
}
