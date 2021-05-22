package planner.dto;

public class Planner3Bean {
	int id;
	int planner_area_id;
	int order_num;
	int content_id;
	int content_type_id;
	
	public Planner3Bean(int id, int planner_area_id, int order_num, int content_id, int content_type_id) {
		super();
		this.id = id;
		this.planner_area_id = planner_area_id;
		this.order_num = order_num;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
	}
	public Planner3Bean(int planner_area_id, int order_num, int content_id, int content_type_id) {
		super();
		this.planner_area_id = planner_area_id;
		this.order_num = order_num;
		this.content_id = content_id;
		this.content_type_id = content_type_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanner_area_id() {
		return planner_area_id;
	}
	public void setPlanner_area_id(int planner_area_id) {
		this.planner_area_id = planner_area_id;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
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
}
