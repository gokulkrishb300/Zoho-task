package accountdeclare;

import java.util.Date;

public class Ticket {
private int ticketId;
private long time;
private float dollar;
private boolean status;
private String vehicleType;
private String vehicleNum;
private int floor;
private float paidAmount;
private String cashType;






public String getCashType() {
	return cashType;
}
public void setCashType(String cashType) {
	this.cashType = cashType;
}

public float getPaidAmount() {
	return paidAmount;
}
public void setPaidAmount(float paidAmount) {
	this.paidAmount = paidAmount;
}
public int getFloor() {
	return floor;
}
public void setFloor(int floor) {
	this.floor = floor;
}
public int getTicketId() {
	return ticketId;
}
public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
public long getTime() {
	return time;
}
public void setTime(long millis) {
	this.time = millis;
}
public float getDollar() {
	return dollar;
}
public void setDollar(float dollar) {
	this.dollar = dollar;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getVehicleTYpe() {
	return vehicleType;
}
public void setVehicleModel(String vehicleType) {
	this.vehicleType = vehicleType;
}
public String getVehicleNum() {
	return vehicleNum;
}
public void setVehicleNum(String vehicleNum) {
	this.vehicleNum = vehicleNum;
}
java.util.Date date = new java.util.Date(getTime());
@Override
public String toString() {
	return "Ticket [ticketId=" + ticketId + ", time=" + date + ", dollar=" + dollar + ", status=" + status
			+ ", vehicleType=" + vehicleType + ", vehicleNum=" + vehicleNum + ", floor=" + floor + ", paidAmount="
			+ paidAmount + ", cashType=" + cashType + "]";
}






}
