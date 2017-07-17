package lists_and_arrays;

import java.util.ArrayList;

public class Levels {
	
	private ArrayList<Parking> park;
	public int park_count;
	
	public Levels(ArrayList<Parking> park) {
		super();
		this.park = park;
	}
	
	public Levels(){		
	}

	public void initParking (int num_park){
		if (park == null){
			park = new ArrayList<Parking>();
		} else {
			System.out.println("Parking already initiated");
		}
	}

	public void addParkings (int number_of_parking_spaces){
		while (park_count != number_of_parking_spaces){
			park.add(new Parking(park_count, null, false));
			park_count++;
		}
	}
	
	public int getPark_count() {
		return park_count;
	}

	public ArrayList<Parking> getPark() {
		return park;
	}

	public void setPark(ArrayList<Parking> park) {
		this.park = park;
	}

	public void setPark_count(int park_count) {
		this.park_count = park_count;
	}
	
	

}
