package community;

public class CommunityBean {
	
	public int id;
	public String username;
	public String title;
	public String content;
	public String register_date;

	
	public CommunityBean(int id, String username, String title, String content, String register_date) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.content = content;
		this.register_date = register_date;
		
	}
	
	
	public CommunityBean(String title, String content) {
		super();
		
		
		this.title = title;
		this.content = content;
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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