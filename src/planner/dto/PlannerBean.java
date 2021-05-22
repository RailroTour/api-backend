package planner.dto;

import java.sql.Date;

public class PlannerBean {
	public int id;
	public int user_id;
	public String title;
	public Boolean disclosure;
	public String register_date;
	
	public int days;
	public int tema_id;
	public String img_path;
	public String start_day;
	
	
	
	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getDisclosure() {
		return disclosure;
	}

	public void setDisclosure(Boolean disclosure) {
		this.disclosure = disclosure;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
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

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public PlannerBean(int id, int user_id, String title, Boolean disclosure, String register_date, int days, int tema_id,
			String img_path, String start_day) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.disclosure = disclosure;
		this.register_date = register_date;
		this.days = days;
		this.tema_id = tema_id;
		this.img_path = img_path;
		this.start_day = start_day;
	}
	
	public PlannerBean(String title, Boolean disclosure, int days, int tema_id,
			String img_path, String start_day) {
		
		this.title = title;
		this.disclosure = disclosure;
		this.days = days;
		this.tema_id = tema_id;
		this.img_path = img_path;
		this.start_day = start_day;
	}
	public PlannerBean(String title, Boolean disclosure, int days, int tema_id, String start_day) {
		this.title = title;
		this.disclosure = disclosure;
		this.days = days;
		this.tema_id = tema_id;
		this.start_day = start_day;
	}
	public PlannerBean(int id, int user_id, String title, Boolean disclosure, int days, int tema_id,
			String img_path, String start_day) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.disclosure = disclosure;
		this.days = days;
		this.tema_id = tema_id;
		this.img_path = img_path;
		this.tema_id = tema_id;
		this.start_day = start_day;
	}

}
