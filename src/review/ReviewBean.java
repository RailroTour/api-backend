package review;

import java.util.ArrayList;
import java.util.List;

public class ReviewBean {
	
	private int id;
	private int user_id;
	private int content_id;
	private int content_type_id;
	private String content;
	private String register_date;
	private List<String> img_paths; 
	private List<String> tags;
	int like;
	int mine; //내꺼인지
	String nickname;
	
	public int getMine() {
		return mine;
	}

	public void setMine(int mine) {
		this.mine = mine;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

	public ReviewBean(int id, int user_id, int content_id, int content_type_id, String content, String register_date,
			List<String> img_paths, List<String> tags, int like, int mine, String nickname) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.content = content;
		this.register_date = register_date;
		this.img_paths = img_paths;
		this.tags = tags;
		this.like = like;
		this.mine = mine;
		this.nickname = nickname;
	}

	public ReviewBean(int id, int user_id, int content_id, int content_type_id, String content, String register_date,
			int like) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.content = content;
		this.register_date = register_date;
		this.like = like;
	}
	
	public ReviewBean(int id, int user_id, int content_id, int content_type_id, String content, String register_date,
			int like, int mine, String nickname) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.content = content;
		this.register_date = register_date;
		this.like = like;
		this.mine = mine;
		this.nickname = nickname;
	}

	public ReviewBean(int id, int user_id, int content_id, int content_type_id, String content, String register_date,
			List<String> img_paths, List<String> tags, int like) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.content = content;
		this.register_date = register_date;
		this.img_paths = img_paths;
		this.tags = tags;
		this.like = like;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public ReviewBean() {
		super();
		this.img_paths = new ArrayList<String>();
		this.tags = new ArrayList<String>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public int getContent_type_id() {
		return content_type_id;
	}
	public void setContent_type_id(int content_type_id) {
		this.content_type_id = content_type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public List<String> getImg_paths() {
		return img_paths;
	}
	public void setImg_paths(List<String> img_paths) {
		this.img_paths = img_paths;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	
}
