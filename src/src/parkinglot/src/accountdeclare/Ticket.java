package accountdeclare;

public class Ticket {
private int ticketId;
private Object time;
private float dollar;
private boolean status;
private String vehicleModel;
private String vehicleNum;
private int floor;
private float paidAmount;

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
public Object getTime() {
	return time;
}
public void setTime(Object time) {
	this.time = time;
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
public String getVehicleModel() {
	return vehicleModel;
}
public void setVehicleModel(String vehicleModel) {
	this.vehicleModel = vehicleModel;
}
public String getVehicleNum() {
	return vehicleNum;
}
public void setVehicleNum(String vehicleNum) {
	this.vehicleNum = vehicleNum;
}
@Override
public String toString() {
	return "Ticket [ticketId=" + ticketId + ", time=" + time + ", dollar=" + dollar + ", status=" + status
			+ ", vehicleModel=" + vehicleModel + ", vehicleNum=" + vehicleNum + ", floor=" + floor + ", paidAmount="
			+ paidAmount + "]";
}



}
