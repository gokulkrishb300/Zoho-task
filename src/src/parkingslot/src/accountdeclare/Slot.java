package accountdeclare;

public class Slot {
	private int slotNumber;
	private int space;
	private String vehicleModel;
	private boolean electricPanel;
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
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
		return "Slot [slotNumber=" + slotNumber + ", space=" + space + ", vehicleModel=" + vehicleModel
				+ ", electricPanel=" + electricPanel + "]";
	}
	
	
	
	

	
	
}
