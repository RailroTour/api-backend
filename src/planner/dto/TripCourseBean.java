package planner.dto;

public class TripCourseBean {
	String sigungu_name;
	int contenttypeid;
	int contentid;
	int visit_day;
	int order_num;
	
	public TripCourseBean(String sigungu_name, int contenttypeid, int contentid, int visit_day, int order_num) {
		super();
		this.sigungu_name = sigungu_name;
		this.contenttypeid = contenttypeid;
		this.contentid = contentid;
		this.visit_day = visit_day;
		this.order_num = order_num;
	}
	
	public String getSigungu_name() {
		return sigungu_name;
	}
	public void setSigungu_name(String sigungu_name) {
		this.sigungu_name = sigungu_name;
	}
	public int getContenttypeid() {
		return contenttypeid;
	}
	public void setContenttypeid(int contenttypeid) {
		this.contenttypeid = contenttypeid;
	}
	public int getContentid() {
		return contentid;
	}
	public void setContentid(int contentid) {
		this.contentid = contentid;
	}
	public int getVisit_day() {
		return visit_day;
	}
	public void setVisit_day(int visit_day) {
		this.visit_day = visit_day;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
}
