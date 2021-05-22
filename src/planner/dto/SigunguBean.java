package planner.dto;

public class SigunguBean {
	int id;
	int area_code;
	String area_name;
	int sigungu_code;
	String sigungu_name;
	String thumb;
	
	public SigunguBean(int id, int area_code, String area_name, int sigungu_code, String sigungu_name, String thumb) {
		super();
		this.id = id;
		this.area_code = area_code;
		this.area_name = area_name;
		this.sigungu_code = sigungu_code;
		this.sigungu_name = sigungu_name;
		this.thumb = thumb;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
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
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	
	
}
