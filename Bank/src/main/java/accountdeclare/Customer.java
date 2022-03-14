package accountdeclare;

import java.io.Serializable;

public class Customer implements Serializable
{
	private int customerID;
	private String customerName;
	private String address;
	private long mobile;
	private boolean status=true;
	
	public int getCustomerId() {
		return customerID;
	}
	public void setCustomerId(int customerID) {
		this.customerID = customerID;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	@Override
	public String toString() {
		return "customerName = " + customerName + ", address = " + address + ", mobile = " + mobile;
	}
	

}
