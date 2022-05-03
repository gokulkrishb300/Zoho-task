package accountdeclare;

public class Slot {

	private int slotNo;
	private String preference;
	public int getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	@Override
	public String toString() {
		return "Slot [slotNo=" + slotNo + ", preference=" + preference + "]";
	}
	
}
