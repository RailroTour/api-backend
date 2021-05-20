package review;

public class ReviewBean {
	
	public int id;
	public int user_id;
	public int content_id;
	public int content_type_id;
	public String image_path;
	public String content;
	public String register_date;
	public ReviewBean(int id, int user_id, int content_id, int content_type_id, String image_path, String content,
			String register_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.image_path = image_path;
		this.content = content;
		this.register_date = register_date;
	}
	
	public ReviewBean(int content_id, int content_type_id, String image_path, String content) {

		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.image_path = image_path;
		this.content = content;
		
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
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
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
	

}
