package tripcart.dto;

public class TripCartBean {
	public int id;
	public int user_id;
	public int division_id;
	public int serial_num;
	
	public TripCartBean(int id, int user_id, int division_id, int serial_num) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.division_id = division_id;
		this.serial_num = serial_num;
	}
	public TripCartBean(int user_id, int division_id, int serial_num) {
		super();
		
		this.user_id = user_id;
		this.division_id = division_id;
		this.serial_num = serial_num;
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

	public int getDivision_id() {
		return division_id;
	}

	public void setDivision_id(int division_id) {
		this.division_id = division_id;
	}

	public int getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(int serial_num) {
		this.serial_num = serial_num;
	}
	

}
