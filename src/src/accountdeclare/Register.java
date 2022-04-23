package accountdeclare;

public class Register {
private int userID;
private int password;

public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
@Override
public String toString() {
	return "Your userID = " + userID + " and password = " + password ;
}

}
