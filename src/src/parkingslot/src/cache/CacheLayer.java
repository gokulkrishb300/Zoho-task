package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accountdeclare.Passenger;
import accountdeclare.Slot;
import accountdeclare.Ticket;

public class CacheLayer {

	Map<String, List<Slot>> bluePrint = new HashMap<>();
	Map<Integer, List<Passenger>> bookTicket = new HashMap<>();

	List<Passenger> passList = new ArrayList<>();

	private int ticket = 1000;

	private int ticket() {
		return ++ticket;
	}

	private int waiting_list = 0;

	private String ticketType = null;

	public Map<String, List<Slot>> bluePrint(int compet, int wait_list) {

		int k = 1;

		waiting_list = wait_list;

		for (int i = 0; i < compet; i++) {

			List<Slot> list = new ArrayList<>();
			for (int j = 1; j <= 2; j++) {

				Slot slot = new Slot();
				slot.setSlotNo(k++);
				slot.setPreference("LowerBerth");
				list.add(slot);
			}
			bluePrint.put("LowerBerth", list);

			// System.out.println(list);

			list = new ArrayList<>();
			for (int j = 1; j <= 2; j++) {
				Slot slot = new Slot();
				slot.setSlotNo(k++);
				slot.setPreference("MiddleBerth");
				list.add(slot);
			}
			bluePrint.put("MiddleBerth", list);

			list = new ArrayList<>();
			for (int j = 1; j <= 2; j++) {
				Slot slot = new Slot();
				slot.setSlotNo(k++);
				slot.setPreference("UpperBerth");
				list.add(slot);
			}
			bluePrint.put("UpperBerth", list);

			list = new ArrayList<>();
			for (int j = 1; j <= 2; j++) {
				Slot slot = new Slot();
				slot.setSlotNo(k++);
				slot.setPreference("RAC");
				list.add(slot);
			}
			bluePrint.put("RAC", list);

			list = new ArrayList<>();
			for (int j = 1; j <= 1; j++) {
				Slot slot = new Slot();
				slot.setSlotNo(k++);
				slot.setPreference("SideUpperBerth");
				list.add(slot);
			}
			bluePrint.put("SideUpperBerth", list);
		}
		return bluePrint;
	}

	public Map<String, List<Slot>> showAvailableTickets() {
		return bluePrint;
	}

	public Map<Integer, List<Passenger>> showBookedTickets() {
		return bookTicket;
	}

	public Object bookTicket(Ticket ticket) {

		

		ticket.setTicket(ticket());
		ticket.setTime(System.currentTimeMillis());
		ticket.setAmount(ticket.getNoOfPassenger() * 100);
		ticket.setTicketType(ticketType);
		
		
		bookTicket.put(ticket.getTicket(), passList);
		//passList.clear();
		//System.out.println(bookTicket);
		return ticket + "\n" + bookTicket.get(ticket.getTicket());
	}

	private String ticketType(String berth) {
		
		Map<String,String> map = new HashMap<>();
		
		map.put("LowerBerth", "normal");
		map.put("MiddleBerth", "normal");
		map.put("UpperBerth", "normal");
		map.put("SideUpperBerth", "normal");
		map.put("RAC", "RAC");
		map.put("Waiting", "Waiting");
		
		return map.get(berth);
	}
	

	
	public Object passenger(Passenger passenger, String berth) {

		List<Slot> temp = bluePrint.get(berth);

		Slot slot = null;
		if (!temp.isEmpty()) {
			slot = temp.remove(0);
			ticketType = ticketType(berth);
			passenger.setBerthPreference(slot.getPreference());
			passenger.setSeatNo(slot.getSlotNo());
			passList.add(passenger);
			return passList;
		
		} else {

			if (!bluePrint.get("UpperBerth").isEmpty()) {
			
				return passenger(passenger, "UpperBerth");
			} else if (!bluePrint.get("MiddleBerth").isEmpty()) {
				
				return passenger(passenger, "MiddleBerth");
			} else if (!bluePrint.get("LowerBerth").isEmpty()) {
				
				return passenger(passenger, "LowerBerth");
			} else if (!bluePrint.get("SideUpperBerth").isEmpty()) {
				
				return passenger(passenger, "SideUpperBerth");
			} else if (!bluePrint.get("RAC").isEmpty()) {
				
				return passenger(passenger, "RAC");
			} else {
				
				System.out.println("Waiting-List");
			}
		}
		
		return "";

	}

	public void berthDetails() {
		System.out.println();
	}
}
