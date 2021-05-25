package train;

public class StationBean {
	int id;
	int citycode;
	String cityname;
	String nodeid;
	String nodename;
	
	
	public StationBean(int id, int citycode, String cityname, String nodeid, String nodename) {
		super();
		this.id = id;
		this.citycode = citycode;
		this.cityname = cityname;
		this.nodeid = nodeid;
		this.nodename = nodename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public String getNodename() {
		return nodename;
	}
	public void setNodename(String nodename) {
		this.nodename = nodename;
	}
	
	
}
