
//this class is a sub class of the vehicle super class and vehicle also a abstract class
public class Motorbike extends vehicle {

	//
	private String idPlate;
	private String vehicleBrand;
	private String engineSize;
	private DateTime inTime;
	private DateTime outTime;
	private String type;

	// two argument constructor for this class
	Motorbike(DateTime inTime, String type) {

		this.inTime = inTime;
		this.type = type;
	}

	// single argument constructor for the motorbike class
	Motorbike(DateTime outTime) {

		this.outTime = outTime;

	}

	// to get the type of the vehicle
	public String getType() {
		return type;
	}

	// to set the vehicle type usning setter
	public void setType(String type) {
		this.type = type;
	}

	// get the date and time as a string
	public String getDateTime() {
		// System.out.printf("%s", inTime);
		return String.format("%s", inTime);
	}

	// get the id plate number using getter
	public String getIdPlate() {
		return idPlate;
	}

	// to set the id plate
	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	// to get the vehicle brand
	public String getVehicleBrand() {
		return vehicleBrand;
	}

	// to set the vehicle brand
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	// to get the engine capacity of the bike
	public String getEngineSize() {
		return engineSize;
	}

	// to set the engine capacity of the bike
	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public DateTime getDateTimeIn() {
		return inTime;
	}

	public DateTime getDateTimeOut() {
		return outTime;
	}

	// to return a string from the class
	public String toString() {
		return String.format("ID Plate_NUM: %s      Entrance details: %s       vehicle TYPE: %s", idPlate, inTime,
				type);
	}

}