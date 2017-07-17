package main;

import java.util.ArrayList;

import lists_and_arrays.Levels;
import models.Car;

public class Main {
	
	public int num_lv = 0;
	private ArrayList<Levels> lv;
	
	private ArrayList<Car> car;
	public int car_count = 0;
	
	public void initLevels (){
		if (lv == null){
			lv = new ArrayList<Levels>();
			System.out.println("Initiate Building Levels");
		} else {
			System.out.println("Level already initiated");
		}
	}
	
	public void addLevels (int number_of_levels){
		if(((lv != null)&&(num_lv==0))){
			while (num_lv != number_of_levels){
				lv.add(new Levels());
				num_lv++;
				System.out.println("Building level:"+num_lv);
			}
		} else {
			System.out.println("Level's not initiated, use initLevels method");
		}
	}
	
	public void addParking (int number_of_parking_spaces_per_level){
		if(num_lv != 0){
			for (int i1=0; i1<num_lv; i1++){
				lv.get(i1).initParking(number_of_parking_spaces_per_level);
				System.out.println("Initiate Parking "+ i1);
				for (int i2=0; i2<number_of_parking_spaces_per_level; i2++){
					lv.get(i1).addParkings(number_of_parking_spaces_per_level);
					System.out.println("Add Parking "+ i2);
				}
			}
		} else {
			System.out.println("You cannot add parking without level, use addLevels method");
		}
	}
	
	//was public for testing
	private int[] findParkingSpot (){
		if(num_lv != 0){
			for (int i1=0; i1<num_lv; i1++){
				for (int i2=0; i2<lv.get(i1).getPark_count(); i2++){
					if(!(lv.get(i1).getPark().get(i2).isTaken())){
						//lv.get(i1).getPark().get(i2).setTaken(true);
						int[] A = {i1,i2};
						System.out.println("Free spot on level: "+i1+" , spot "+i2);
						return A;
					}
				}
			}
			System.out.println("There are no free Parking spots.");
		} else {
			System.out.println("There are no levels of building.");
		}
		return null;
	}
	
	private int[] findParkedCar1 (String licence_plate){
		for (int i1=0; i1<num_lv; i1++){
			for (int i2=0; i2<lv.get(i1).getPark_count(); i2++){
				if((licence_plate==lv.get(i1).getPark().get(i2).getLicence_plate())){
					//System.out.println("Your car is on level:"+i1+",on parking spot:"+i2+".");
					int[] A = {i1,i2};
					return A;
				}
			}
		}
		System.out.println("Sorry, your car is not parked in this Garade.");
		return null;
	}
	
	public void findParkedCar (String licence_plate){
		int[] B = findParkedCar1(licence_plate);
		System.out.println("Your car is on level:"+B[0]+",on parking spot:"+B[1]+".");
	}
	
	public void initCarList (){
		if (car == null){
			car = new ArrayList<Car>();
		} else {
			System.out.println("Car List already initiated");
		}
	}
	
	//was public for testing
	private int addCar (String licence_plate, String car_type){
		if(car != null){
			for (int i=0; i<car_count; i++){
				if (car.get(i).getLicence_plate()==licence_plate){
					if (car.get(i).isParked()==true){
						System.out.println("Car is already parked. There cannot be two cars with the same licence plate.");
						return -1;
					} else {
						//car.get(i).setParked(true);
						//System.out.println("Car is parked");
						return i;
					}
				}
			}
			//car.add(new Car(licence_plate, car_type, true));
			//car_count++;
			//System.out.println("Car with licence plate:"+ licence_plate +" and type: "+ car_type +" is parked.");
			return -2;
		} else {
			System.out.println("Car list not initiated, use initCarList method");
		}
		return -1;
	}
	
	public void addCarToParkingSpace (String licence_plate, String car_type){
		int carState = addCar(licence_plate, car_type);
		int [] parking_spot = findParkingSpot();
			if (carState == -2){
				if(parking_spot !=null){
				lv.get(parking_spot[0]).getPark().get(parking_spot[1]).setTaken(true);
				lv.get(parking_spot[0]).getPark().get(parking_spot[1]).setLicence_plate(licence_plate);
				car.add(new Car(licence_plate, car_type, true));
				car_count++;
				System.out.println("Car with licence plate:"+ licence_plate +" and type:"+ car_type +" is parked.");
				}
			}
			if (carState >= 0){
				if(parking_spot !=null){
				lv.get(parking_spot[0]).getPark().get(parking_spot[1]).setTaken(true);
				lv.get(parking_spot[0]).getPark().get(parking_spot[1]).setLicence_plate(licence_plate);
				car.get(carState).setParked(true);
				System.out.println("Car is parked");
				}
			}
		}
	
	//not used
	public void removeCar (String licence_plate){
		if(car != null){
			for (int i=0; i<car_count; i++){
				if ((car.get(i).getLicence_plate()==licence_plate)&&(car.get(i).isParked())){
					int []B = findParkedCar1(licence_plate);
					lv.get(B[0]).getPark().get(B[1]).setTaken(false);
					lv.get(B[0]).getPark().get(B[1]).setLicence_plate(null);
					car.get(i).setParked(false);
					System.out.println("The car left the Garage, but is in the list.");
				} else {
					System.out.println("The car is not in the list");
				}
			}
		} else {
			System.out.println("There are no cars");
		}
	}
	
	public static void main(String[] args) {
		
		Main m = new Main();
		m.initLevels();
		m.addLevels(2);
		m.addParking(3);
		m.initCarList();
		//m.findParkingSpot();
		//m.findParkingSpot();
		//m.addCar("TG_1","car");
		//m.addCar("TG_1","car");
		m.addCarToParkingSpace("TG_1", "car");
		//m.addCarToParkingSpace("TG_1", "car");
		//m.addCarToParkingSpace("TG_1", "car");
		m.findParkedCar("TG_1");
		m.removeCar("TG_1");

	}



}
