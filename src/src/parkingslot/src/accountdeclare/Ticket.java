package accountdeclare;

public class Ticket {

	private int ticketId;
	private String vehicleNum;
	private String vehicleType;
	private String cashType;
	private long time;
	private int floor;
	private int slot;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getCashType() {
		return cashType;
	}
	public void setCashType(String cashType) {
		this.cashType = cashType;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", vehicleNum=" + vehicleNum + ", vehicleType=" + vehicleType
				+ ", cashType=" + cashType + ", time=" + time + ", floor=" + floor + ", slot=" + slot + "]";
	}
	
	
}
