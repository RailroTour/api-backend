package top100;

import java.util.ArrayList;
import java.util.List;

public class Top100Bean {
	int contentid;
	int contenttypeid;
	int review_cnt;
	int likes_cnt;
	List<String> tags;
	
	public Top100Bean() {
		super();
		tags = new ArrayList<String>();
	}

	public Top100Bean(int contentid, int contenttypeid, int review_cnt, int likes_cnt) {
		super();
		this.contentid = contentid;
		this.contenttypeid = contenttypeid;
		this.review_cnt = review_cnt;
		this.likes_cnt = likes_cnt;
	}

	
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public int getContentid() {
		return contentid;
	}
	public void setContentid(int contentid) {
		this.contentid = contentid;
	}
	public int getContenttypeid() {
		return contenttypeid;
	}
	public void setContenttypeid(int contenttypeid) {
		this.contenttypeid = contenttypeid;
	}
	public int getReview_cnt() {
		return review_cnt;
	}
	public void setReview_cnt(int review_cnt) {
		this.review_cnt = review_cnt;
	}
	public int getLikes_cnt() {
		return likes_cnt;
	}
	public void setLikes_cnt(int likes_cnt) {
		this.likes_cnt = likes_cnt;
	}
	
	
}
