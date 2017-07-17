package lists_and_arrays;

public class Parking {
	
	public int park_num;
	private String park_type;
	private boolean taken;
	private String licence_plate;
	
	public Parking(int park_num, String park_type, boolean taken) {
		super();
		this.park_num = park_num;
		this.park_type = park_type;
		this.taken = taken;
	}
	
	public String getPark_type() {
		return park_type;
	}
	public void setPark_type(String park_type) {
		this.park_type = park_type;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public int getPark_num() {
		return park_num;
	}

	public void setPark_num(int park_num) {
		this.park_num = park_num;
	}

	public String getLicence_plate() {
		return licence_plate;
	}

	public void setLicence_plate(String licence_plate) {
		this.licence_plate = licence_plate;
	}
	

}
