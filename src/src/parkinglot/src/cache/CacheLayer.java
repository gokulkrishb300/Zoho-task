package cache;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import accountdeclare.Ticket;
import manualexception.ManualException;

public class CacheLayer {
	
Map<Integer,Map<String,Integer>> bluePrint = new HashMap<>();
	
	Map<String,Integer> vehicleSpot = new HashMap<>();
	
	Map<Integer,Integer> availableSpots = new HashMap<>();
	
	private int ticketId = 1000;
	
	private int vehicle = 3333;	
	
	private String vehicleNum = "TN 63 A "+vehicle;
	
	private int ticketGen() {
		
		return ++ticketId;
	}
	
	private String vehicleNum() {
		
		++vehicle;
		
		vehicleNum = "TN 63 A "+vehicle;
		
		return vehicleNum;
	}
	
	
	private String vehicleType(String vehicleName) throws ManualException {
		
		Map<String,String> vehicleModel = new HashMap<>();
		
		vehicleModel.put("van","large");
		vehicleModel.put("car","compact");
		vehicleModel.put("truck","large");
		vehicleModel.put("motorcycle","motorcycle");
		vehicleModel.put("electric","electric");
		vehicleModel.put("tricycle","handicapped");
		
		return vehicleModel.get(vehicleName);
	}
	
	public Map<Integer,Map<String,Integer>> bluePrint(int floor) throws ManualException{
		
		int count = 2;
		
		vehicleSpot.put("compact",count*floor);
		vehicleSpot.put("large",count*floor);
		vehicleSpot.put("handicapped", count*floor);
		vehicleSpot.put("motorcycle", count*floor);
		vehicleSpot.put("electric", count*floor);
		
		
		for(int i = 0 ; i < floor ; i++) {
			
			bluePrint.put(i, vehicleSpot);
		}
		
		return bluePrint;
	}
	
	public Map<Integer, Map<String, Integer>> showAllFloor() {
		
		return bluePrint;
	}
	
	public Map<Integer, Integer> searchMySpots(int floor,String vehicleName) throws ManualException {
		
		String vehicleMod = vehicleType(vehicleName);
		
		for(int i = 0 ; i < floor ; i++) {
			
			availableSpots.put(i,bluePrint.get(i).get(vehicleMod));
			}
		
		return availableSpots;
		
	}
	
	public Map<Integer, Integer> reduceSpot(int floor,String vehicleName) throws ManualException {
		
		String vehicleMod = vehicleType(vehicleName);
		
	    availableSpots.put(floor, bluePrint.get(floor).get(vehicleMod)-1);
	    
	    System.out.println(availableSpots);
	    
	    return availableSpots;
	}
	
	public String timeGenerate() {
		
		SimpleDateFormat format = new SimpleDateFormat("mm");
		
		Date date = new Date();
		
		String minute = format.format(date);
		
		return minute;
	}
	
	public Object ticket(Ticket ticket) throws ManualException{
		
		ticket.setDollar(4);
		
		ticket.setVehicleNum(vehicleNum());
		
		ticket.setTime(timeGenerate());
		
		ticket.setTicketId(ticketGen());
		
		return ticket;
	}
	
	
}
