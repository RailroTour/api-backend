package RecommendPlanner;

public class RecommendPlannerBean {
	int id;
	String tema_name;
	int tema_id;
	String cover_img;
	int view;
	String nickname;
	int days;
	String title;
	
	public RecommendPlannerBean(int id, String tema_name, int tema_id, String cover_img, int view, String nickname,
			int days, String title) {
		super();
		this.id = id;
		this.tema_name = tema_name;
		this.tema_id = tema_id;
		this.cover_img = cover_img;
		this.view = view;
		this.nickname = nickname;
		this.days = days;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTema_name() {
		return tema_name;
	}
	public void setTema_name(String tema_name) {
		this.tema_name = tema_name;
	}
	public int getTema_id() {
		return tema_id;
	}
	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}
	public String getCover_img() {
		return cover_img;
	}
	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
