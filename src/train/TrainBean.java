package train;

public class TrainBean {
	String depplandtime;
	String arrplandtime;
	String adultcharge;
	String trainno;
	String arrplacename;
	String depplacename;
	String traingradename;
	public TrainBean(String depplandtime, String arrplandtime, String adultcharge, String trainno, String arrplacename,
			String depplacename, String traingradename) {
		super();
		this.depplandtime = depplandtime;
		this.arrplandtime = arrplandtime;
		this.adultcharge = adultcharge;
		this.trainno = trainno;
		this.arrplacename = arrplacename;
		this.depplacename = depplacename;
		this.traingradename = traingradename;
	}
	public String getDepplandtime() {
		return depplandtime;
	}
	public void setDepplandtime(String depplandtime) {
		this.depplandtime = depplandtime;
	}
	public String getArrplandtime() {
		return arrplandtime;
	}
	public void setArrplandtime(String arrplandtime) {
		this.arrplandtime = arrplandtime;
	}
	public String getAdultcharge() {
		return adultcharge;
	}
	public void setAdultcharge(String adultcharge) {
		this.adultcharge = adultcharge;
	}
	public String getTrainno() {
		return trainno;
	}
	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}
	public String getArrplacename() {
		return arrplacename;
	}
	public void setArrplacename(String arrplacename) {
		this.arrplacename = arrplacename;
	}
	public String getDepplacename() {
		return depplacename;
	}
	public void setDepplacename(String depplacename) {
		this.depplacename = depplacename;
	}
	public String getTraingradename() {
		return traingradename;
	}
	public void setTraingradename(String traingradename) {
		this.traingradename = traingradename;
	}
	
	
}
