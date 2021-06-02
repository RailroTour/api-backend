package community;

public class CommunityBean {

	public int id;
	public String username;
	public String title;
	public String content;
	public String register_date;
	public String community_img;
	public int views;

	public CommunityBean(int id, String username, String title, String content, String register_date,
			String community_img,int views) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.content = content;
		this.register_date = register_date;
		this.community_img = community_img;
		this.views =views;

	}


	public CommunityBean(int id,String title, String content, String community_img) {
		super();
		this.id =id;
		this.title = title;
		this.content = content;
		this.community_img = community_img;

	}
	public CommunityBean(int id, String title, String content) {
		super();
		this.id =id;
		this.title = title;
		this.content = content;
		

	}
	
	public CommunityBean(String title, String content, String community_img) {
		super();
		
		this.title = title;
		this.content = content;
		this.community_img = community_img;

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


	public String getCommunity_img() {
		return community_img;
	}


	public void setCommunity_img(String community_img) {
		this.community_img = community_img;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}
	
	
}