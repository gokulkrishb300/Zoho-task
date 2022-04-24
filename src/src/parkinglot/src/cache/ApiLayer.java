package cache;


import java.util.*;

import accountdeclare.Ticket;
import manualexception.ManualException;

public class ApiLayer {
	
	CacheLayer cache = new CacheLayer();
	
	public Map<Integer,Map<String,Integer>> bluePrint(int floor) throws ManualException{
		
		return cache.bluePrint(floor);
	}
	
	public Map<Integer, Integer> searchMySpots(int floor,String vehicleName) throws ManualException {
		
		return cache.searchMySpots(floor, vehicleName);
	}
	
	public Object ticket(Ticket ticket) throws ManualException {
		
		return cache.ticket(ticket);
	}
	
	public Map<Integer, Map<String, Integer>> showAllFloor() {
		
		return cache.showAllFloor();
	}
	public Map<Integer, Integer> reduceSpot(int floor,String vehicleName) throws ManualException {
		return cache.reduceSpot(floor,vehicleName);
	}
}
