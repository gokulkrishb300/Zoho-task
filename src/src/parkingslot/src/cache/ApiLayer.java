package cache;

import java.util.List;
import java.util.Map;

import accountdeclare.Slot;
import accountdeclare.Ticket;
import manualexception.ManualException;

public class ApiLayer {

	CacheLayer cache = new CacheLayer();
	
	
	public Map<Integer, Map<String, List<Slot>>> bluePrint(int floor,int spot) {
		return cache.bluePrint(floor,spot);
	}
	public Map<Integer, Map<String, List<Slot>>> showBluePrint() {
		return cache.bluePrint;
	}
	
	public String vehicleModel(String vehicleType) {
		return cache.vehicleModel(vehicleType);
	}
	
	public Map<Integer, List<Slot>> searchVehicleSlots(String vehicleModel) {
		return cache.searchVehicleSlots(vehicleModel);
	}
	
//	public List<Slot> bookTicket(int floor, String vehicleModel) {
//		return cache.bookTicket(floor, vehicleModel);
//	}
}
