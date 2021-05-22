package planner.dto;

public class Planner2Bean {
	int id;
	int planner_id;
	int visit_day;
	int sigungu_id;
	
	public Planner2Bean(int id, int planner_id, int visit_day, int sigungu_id) {
		super();
		this.id = id;
		this.planner_id = planner_id;
		this.visit_day = visit_day;
		this.sigungu_id = sigungu_id;
	}
	
	public Planner2Bean(int planner_id, int visit_day, int sigungu_id) {
		super();
		this.planner_id = planner_id;
		this.visit_day = visit_day;
		this.sigungu_id = sigungu_id;
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
	public int getSigungu_id() {
		return sigungu_id;
	}
	public void setSigungu_id(int sigungu_id) {
		this.sigungu_id = sigungu_id;
	}
	
	
}
