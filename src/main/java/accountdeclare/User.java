package accountdeclare;

public class User 
{
	private int userID;
	private String password;
	private int roleID;
	private int customerID;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", password=" + password + ", roleID=" + roleID + ", customerID=" + customerID
				+ "]";
	}
	

	
}
