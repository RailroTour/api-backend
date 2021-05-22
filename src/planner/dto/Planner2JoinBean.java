package planner.dto;

public class Planner2JoinBean {
	int id;
	int planner_id;
	int visit_day;
	int area_code;
	int sigungu_code;
	String sigungu_name;
	
	public Planner2JoinBean(int id, int planner_id, int visit_day, int area_code, int sigungu_code,
			String sigungu_name) {
		super();
		this.id = id;
		this.planner_id = planner_id;
		this.visit_day = visit_day;
		this.area_code = area_code;
		this.sigungu_code = sigungu_code;
		this.sigungu_name = sigungu_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanner_id() {
		return planner_id;
	}
	public void setPlanner_id(int planner_id) {
		this.planner_id = planner_id;
	}
	public int getVisit_day() {
		return visit_day;
	}
	public void setVisit_day(int visit_day) {
		this.visit_day = visit_day;
	}
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public int getSigungu_code() {
		return sigungu_code;
	}
	public void setSigungu_code(int sigungu_code) {
		this.sigungu_code = sigungu_code;
	}
	public String getSigungu_name() {
		return sigungu_name;
	}
	public void setSigungu_name(String sigungu_name) {
		this.sigungu_name = sigungu_name;
	}
	
	
}
