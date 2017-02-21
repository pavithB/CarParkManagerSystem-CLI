

//this Van class also  a subclass of a vehicle super abstract class
public class Van extends vehicle {

	private String idPlate;
	private String vehicleBrand;
	private String cargoVolume;
	private DateTime inTime;
	private DateTime outTime;
	private String type;

	Van(DateTime inTime, String type) {
		// to get the entrance time and set it to the inTime variable
		this.inTime = inTime;
		this.type = type;
	}

	Van(DateTime outTime) {

		this.outTime = outTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDateTime() {
		// System.out.printf("%s", inTime);
		return String.format("%s", inTime);
	}

	public String getIdPlate() {
		return idPlate;
	}

	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	// to get the the cargo volume of the van
	public String getCargoVolume() {
		return cargoVolume;
	}

	// to set the cargo volume of the van
	public void setCargoVolume(String cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	// acess the compounts in DateTime class using inTme referrence
	public DateTime getDateTimeIn() {
		return inTime;
	}

	public DateTime getDateTimeOut() {
		return outTime;
	}

	// when ask string from this class toString return string from this class
	public String toString() {
		return String.format("ID Plate_NUM: %s      Entrance details: %s       vehicle TYPE: %s", idPlate, inTime,
				type);
	}

}