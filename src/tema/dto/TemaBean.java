package tema.dto;

public class TemaBean {
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
	public TemaBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TemaBean(String name) {
		super();
		
		this.name = name;
	}

}
