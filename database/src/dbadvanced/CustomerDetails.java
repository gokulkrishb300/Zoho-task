package dbadvanced;

public class CustomerDetails {
	
	
	private String name;
	private int age;
	private String gender;
	private long mobile;
	
	
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", age=" + age + ", gender=" + gender + ", mobile="
				+ mobile + "]";
	}
}
