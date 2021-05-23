package planner.dto;

public class PlannerInfoBean {
	String nickname;
	String title;
	String start_day;
	int days;
	String name;
	int view;
	
	public PlannerInfoBean(String nickname, String title, String start_day, int days, String name, int view) {
		super();
		this.nickname = nickname;
		this.title = title;
		this.start_day = start_day;
		this.days = days;
		this.name = name;
		this.view = view;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_day() {
		return start_day;
	}
	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
}
