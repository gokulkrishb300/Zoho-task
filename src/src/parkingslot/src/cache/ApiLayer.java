package cache;

import java.util.List;
import java.util.Map;

import accountdeclare.Passenger;
import accountdeclare.Slot;
import accountdeclare.Ticket;

public class ApiLayer {

	CacheLayer cache = new CacheLayer();
	
	public Map<String, List<Slot>> bluePrint(int compet , int wait_list) {
		return cache.bluePrint(compet,wait_list);
	}
	
	public Object bookTicket(Ticket ticket) {
		return cache.bookTicket(ticket);
	}
	
	public Map<String, List<Slot>> showAvailableTickets() {
		return cache.showAvailableTickets();
	}
	
	public Map<Integer, List<Passenger>> showBookedTickets() {
		return cache.showBookedTickets();
	}
	
	public Object passenger(Passenger passenger , String berth) {
		return cache.passenger(passenger, berth);
	}
}
