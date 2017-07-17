package models;

public class Car {

	private String licence_plate;
	private String car_type;
	private boolean parked;
	
	public Car(String licence_plate, String car_type, boolean parked) {
		super();
		this.licence_plate = licence_plate;
		this.car_type = car_type;
		this.parked = parked;
	}
	public String getLicence_plate() {
		return licence_plate;
	}
	public void setLicence_plate(String licence_plate) {
		this.licence_plate = licence_plate;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public boolean isParked() {
		return parked;
	}
	public void setParked(boolean parked) {
		this.parked = parked;
	}
	
}
