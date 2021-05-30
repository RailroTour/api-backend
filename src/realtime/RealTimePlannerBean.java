package realtime;

public class RealTimePlannerBean {
	int id;
	String title;
	String img_path;
	String nickname;
	
	public RealTimePlannerBean() {
		super();
	}
	
	
	
	
	public RealTimePlannerBean(int id, String title, String img_path, String nickname) {
		super();
		this.id = id;
		this.title = title;
		this.img_path = img_path;
		this.nickname = nickname;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
