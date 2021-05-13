package division.dto;

public class DivisionBean {
	public int id;
	public String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DivisionBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public DivisionBean(String name) {
		super();
		
		this.name = name;
	}
	
	
}
