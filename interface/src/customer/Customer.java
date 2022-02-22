package customer;

public class Customer {

	private String name;
	private String address;
	private long mobile;
	private boolean status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", mobile=" + mobile + ", status=" + status + "]";
	}
	
	
}
