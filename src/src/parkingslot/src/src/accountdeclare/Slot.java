package accountdeclare;

public class Slot {
	private int floor;
	private int slotNumber;
	private String vehicleModel;
	private boolean electricPanel;
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public boolean isElectricPanel() {
		return electricPanel;
	}
	public void setElectricPanel(boolean electricPanel) {
		this.electricPanel = electricPanel;
	}
	@Override
	public String toString() {
		return "Slot [floor=" + floor + ", slotNumber=" + slotNumber + ", vehicleModel=" + vehicleModel
				+ ", electricPanel=" + electricPanel + "]";
	}
	
	
	
	
	

	
	
}
