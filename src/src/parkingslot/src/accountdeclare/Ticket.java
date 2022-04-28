package accountdeclare;

public class Ticket {

	private int ticketId;
	private int customerId;
	private String vehicleNum;
	private String vehicleType;
	private long time;
	private int floor;
	private int slot;
	private boolean electricPanel;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public boolean isElectricPanel() {
		return electricPanel;
	}
	public void setElectricPanel(boolean electricPanel) {
		this.electricPanel = electricPanel;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", customerId=" + customerId + ", floor=" + floor + ", slot=" + slot
				+ ", electricPanel=" + electricPanel + "]";
	}

	
		
	
}
