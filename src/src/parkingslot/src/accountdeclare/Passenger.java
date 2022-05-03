package accountdeclare;

public class Passenger {

	private String name;
	private int age;
	private String gender;
	private String berthPreference;
	private int seatNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBerthPreference() {
		return berthPreference;
	}
	public void setBerthPreference(String berthPreference) {
		this.berthPreference = berthPreference;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", berthPreference="
				+ berthPreference + ", seatNo=" + seatNo + "]";
	}
	
	
}
