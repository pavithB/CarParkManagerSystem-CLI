

import java.util.Scanner;

//Car class is a sub class of the vehicle super abstract class
public class Car extends vehicle {
	// use private variables to encapsulate the data
	private String idPlate;
	private String vehicleBrand;
	private String numOfDoor;
	private String color;
	// this variable reference to the DateTime class
	private DateTime inTime;
	private DateTime outTime;
	private String type;

	// this constructor invoke when two arguments are passed
	Car(DateTime inTime, String type) {

		this.inTime = inTime;
		this.type = type;

	}

	// this constructor invokes when one argument in passed
	Car(DateTime outTime) {

		this.outTime = outTime;

	}

	// to get the type of vehicle
	public String getType() {
		return type;
	}

	// to set the type of the vehicle
	public void setType(String type) {
		this.type = type;
	}

	// to get the date and time as a String out put( using toString method in
	// DateTime clas
	public String getDateTime() {
		// System.out.printf("%s", inTime);
		// return a string
		return String.format("%s", inTime);
	}

	// to get the vehicle Id plate num
	public String getIdPlate() {
		return idPlate;
	}

	// to set the vehicle id plate number
	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	// to get the vehicle brnd
	public String getVehicleBrand() {
		return vehicleBrand;
	}

	// to set the vehicle brand
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	// to get the number of doors
	public String getNumOfDoor() {
		return numOfDoor;
	}

	// to set the set the number of doors
	public void setNumOfDoor(String numOfDoor) {
		this.numOfDoor = numOfDoor;
	}

	// to get the color of the car
	public String getColor() {
		return color;
	}

	// to set the set the color of the car
	public void setColor(String color) {
		this.color = color;
	}

	// to get the entrence time
	public DateTime getDateTimeIn() {
		return inTime;
	}

	// to get the get the exit time
	public DateTime getDateTimeOut() {
		return outTime;
	}

	// to return a string when ask for a String rom this class
	public String toString() {
		return String.format("ID Plate_NUM: %s      Entrance details: %s       vehicle TYPE: %s", idPlate, inTime,
				type);
	}

}