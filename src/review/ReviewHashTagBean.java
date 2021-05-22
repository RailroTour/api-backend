package review;

public class ReviewHashTagBean {
	
	public int id;
	public int review_id;
	public String hashtag;
	public ReviewHashTagBean(int id, int review_id, String hashtag) {
		super();
		this.id = id;
		this.review_id = review_id;
		this.hashtag = hashtag;
	}
	public ReviewHashTagBean(int review_id, String hashtag) {
		super();
		this.review_id = review_id;
		this.hashtag = hashtag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	


}
