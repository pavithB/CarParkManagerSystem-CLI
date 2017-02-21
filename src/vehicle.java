

//create a abstract class and sort out the generalize methods in Car ,Van and motorbike and put in this abstract class as abstracts methods
public abstract class vehicle {
	// String idPlate ;
	// String vehicleBrand;
	// String numOfDoor;
	// String color;
	// DateTime inTime;
	// DateTime outTime;
	// String type;
	// to get the vehicle id plate number
	public abstract String getIdPlate();

	// to set the vehicle id plate numer
	public abstract void setIdPlate(String IdPlate);

	// to get the brand name of the vehicle
	public abstract String getVehicleBrand();

	// to set the brand nameof the vehicle
	public abstract void setVehicleBrand(String vehicleBrand);

	// to get the type of the vehicle
	public abstract String getType();

	// to set the type of the vehicle
	public abstract void setType(String type);

	// to get the the date and time as String
	public abstract String getDateTime();

	// to get the details in DateTime class
	public abstract DateTime getDateTimeIn();

	// public String toString(){
	// return String.format("ID Plate_NUM: %s Entrance details: %s vehicle TYPE:
	// %s", idPlate,inTime,type);
	// }
}
