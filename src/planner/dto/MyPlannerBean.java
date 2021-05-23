package planner.dto;

public class MyPlannerBean {
	int user_id;
	String nickname;
	int planner_id;
	String title;
	int days;
	int tema_id;
	String tema_name;
	String img_path;
	String start_day;
	String trip_course;
	int view;
	
	public MyPlannerBean(int user_id, String nickname, int planner_id, String title, int days, int tema_id,
			String tema_name, String img_path, String start_day, String trip_course, int view) {
		super();
		this.user_id = user_id;
		this.nickname = nickname;
		this.planner_id = planner_id;
		this.title = title;
		this.days = days;
		this.tema_id = tema_id;
		this.tema_name = tema_name;
		this.img_path = img_path;
		this.start_day = start_day;
		this.trip_course = trip_course;
		this.view = view;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPlanner_id() {
		return planner_id;
	}
	public void setPlanner_id(int planner_id) {
		this.planner_id = planner_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getTema_id() {
		return tema_id;
	}
	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}
	public String getTema_name() {
		return tema_name;
	}
	public void setTema_name(String tema_name) {
		this.tema_name = tema_name;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getStart_day() {
		return start_day;
	}
	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}
	public String getTrip_course() {
		return trip_course;
	}
	public void setTrip_course(String trip_course) {
		this.trip_course = trip_course;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	

	
}
