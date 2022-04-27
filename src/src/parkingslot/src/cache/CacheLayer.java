package cache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import manualexception.ManualException;
import accountdeclare.Slot;
import accountdeclare.Ticket;

public class CacheLayer {

	Map<Integer,Map<String,List<Slot>>> bluePrint = new HashMap<>();
	
	Map<String,List<Slot>> vehicleSpace = new HashMap<>();
	
	Map<Integer,Map<String,List<Slot>>> emptyBluePrint = new HashMap<>();
	
	Map<String,List<Slot>> freeSpace = new HashMap<>();
	
	List<Slot> bookedSlot = new ArrayList<>();
	
	public Map<Integer, Map<String, List<Slot>>> bluePrint(int floor,int spot) {
		
		int count = spot;
		
		for(int i = 1 ; i <= 5; i++) {
			
			List<Slot> tempList = new ArrayList<>();
			
			for(int j = 1 ; j <= spot ; j++) {
				
				Slot slot = new Slot();
				
				if(i == 1) {
					
					slot.setSlotNumber(j);
					
					slot.setSpace(count--);
					
					slot.setVehicleModel("compact");
					
					tempList.add(slot);
				}
				
				if(i == 2) {
				
					slot.setSlotNumber(j);
					
					slot.setSpace(count--);
					
					slot.setVehicleModel("large");
					
					tempList.add(slot);
		
				}
				
				if(i == 3) {
					
                 	slot.setSlotNumber(j);
					
					slot.setSpace(count--);
					
					slot.setVehicleModel("handicapped");
					
					tempList.add(slot);
					
				}
				
				if(i == 4) {
					
                 	slot.setSlotNumber(j);
					
					slot.setSpace(count--);
					
					slot.setVehicleModel("motorcycle");
					
					tempList.add(slot);
					
					
				}
				
				if(i == 5) {
					
                 	slot.setSlotNumber(j);
					
					slot.setSpace(count--);
					
					slot.setElectricPanel(true);
					
					slot.setVehicleModel("electric");
					
					tempList.add(slot);
					
					}
			}
			if(i == 1) {
				vehicleSpace.put("compact", tempList);
			}
			if(i == 2) {
				vehicleSpace.put("large", tempList);
			}
			if(i == 3) {
				vehicleSpace.put("handicapped", tempList);
			}
			if(i == 4) {
				vehicleSpace.put("motorcycle", tempList);
			}
			if(i == 5) {
				vehicleSpace.put("electric", tempList);
			}
			count = spot;
		
		}
		for(int k = 0 ; k < floor ; k++) {
			bluePrint.put(k, vehicleSpace);
		}
		
		return bluePrint;
	}
	
	
	public Map<Integer, Map<String, List<Slot>>> showBluePrint() {
		return bluePrint;
	}
	
	
	public String vehicleModel(String vehicleType) {
		
		Map<String,String> vehicleMap = new HashMap<>();
		
		vehicleMap.put("car", "compact");
		vehicleMap.put("van", "large");
		vehicleMap.put("truck", "large");
		vehicleMap.put("motorcycle", "motorcycle");
		vehicleMap.put("tricycle","handicapped");
		vehicleMap.put("electric", "electric");
		
		return vehicleMap.get(vehicleType);
	}
	
	public Map<Integer, List<Slot>> searchVehicleSlots(String vehicleModel) {
		
		Map<Integer,List<Slot>> tempMap = new HashMap<>();
		
		for(int i = 0 ; i < bluePrint.size() ; i++) {
			
			tempMap.put(i, bluePrint.get(i).get(vehicleModel));
		}
		
		return tempMap;
	}

	public List<Slot> bookTicket(String vehicleModel) {
		
		Ticket ticket = new Ticket();
		
		List<Slot> tempList = new ArrayList<>();
		
		int i = 0 ;
		tempList = bluePrint.get(i).get(vehicleModel);
		
		
	
		
		return tempList;
	}
	
	int floor = 0;
	
	public void addRemovedList(String vehicleModel) {
		
		
		
		Slot slot = emptyBluePrint.get(floor).get(vehicleModel).get(0);
		
		if(slot == null ) {
			floor++;
		}
		
		bookedSlot.add(slot);
		
	}
}
