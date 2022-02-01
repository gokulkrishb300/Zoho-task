package inheritmethod;

public class Car {

	private int yearOfMake;
	private String engineNum;
	private String vehicleType;
	
	public Car() {
	System.out.println("Hai321");	
	}
	
	public Car(String input) {
		System.out.println(input);
	}
	
	public int getYearOfMake() {
		return yearOfMake;
	}
	public void setYearOfMake(int yearOfMake) {
		this.yearOfMake = yearOfMake;
	}
	public String getEngineNum() {
		return engineNum;
	}
	public void setEngineNum(String engineNum) {
		this.engineNum = engineNum;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public void maintainance() {
		System.out.println("car under maintaining services");
	}
	
}



