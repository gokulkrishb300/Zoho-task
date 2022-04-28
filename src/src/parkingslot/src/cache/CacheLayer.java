package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import manualexception.ManualException;
import accountdeclare.Customer;
import accountdeclare.Slot;
import accountdeclare.Ticket;

public class CacheLayer {

	Map<Integer, Map<String, List<Slot>>> bluePrint = new HashMap<>();

	Map<Integer, Ticket> ticketMap = new HashMap<>();
	
	Map<Integer,Customer> customerMap = new HashMap<>();
	
	Map<String,Integer> vehicleMap = new HashMap<>();

	List<Slot> bookedSlot = new ArrayList<>();

	private int ticketId = 1000;

	private int ticketId() {
		return ++ticketId;
	}

	private int customerId = 100;

	private int customerId() {

		return ++customerId;
	}

	public Map<Integer, Map<String, List<Slot>>> bluePrint(int floor, int spot) {
		int k = 1;
		for (int i = 0; i < floor; i++) {
			Map<String, List<Slot>> fullSpace = new HashMap<>();
			List<Slot> slotList = new ArrayList<>();
			for (int j = 1; j <= spot; j++) {
				Slot slot = new Slot();
				slot.setFloor(i);
				slot.setSlotNumber(k++);
				slot.setVehicleModel("compact");
				slotList.add(slot);
			}
			fullSpace.put("compact", slotList);
			slotList = new ArrayList<>();

			for (int j = 1; j <= spot; j++) {
				Slot slot = new Slot();
				slot.setFloor(i);
				slot.setSlotNumber(k++);
				slot.setVehicleModel("large");
				slotList.add(slot);
			}
			fullSpace.put("large", slotList);
			slotList = new ArrayList<>();
			for (int j = 1; j <= spot; j++) {
				Slot slot = new Slot();
				slot.setFloor(i);
				slot.setSlotNumber(k++);
				slot.setVehicleModel("handicap");
				slotList.add(slot);
			}
			fullSpace.put("handicap", slotList);
			slotList = new ArrayList<>();
			for (int j = 1; j <= spot; j++) {
				Slot slot = new Slot();
				slot.setFloor(i);
				slot.setSlotNumber(k++);
				slot.setVehicleModel("motorcycle");
				slotList.add(slot);
			}
			fullSpace.put("motorcycle", slotList);
			slotList = new ArrayList<>();
			for (int j = 1; j <= spot; j++) {
				Slot slot = new Slot();
				slot.setFloor(i);
				slot.setSlotNumber(k++);
				slot.setVehicleModel("electric");
				slot.setElectricPanel(true);
				slotList.add(slot);
			}
			fullSpace.put("electric", slotList);
			bluePrint.put(i, fullSpace);
		}
		return bluePrint;
	}

	public Map<Integer, Map<String, List<Slot>>> showBluePrint() {
		return bluePrint;
	}

	public String vehicleModel(String vehicleType) {

		Map<String, String> vehicleMap = new HashMap<>();

		vehicleMap.put("car", "compact");
		vehicleMap.put("van", "large");
		vehicleMap.put("truck", "large");
		vehicleMap.put("motorcycle", "motorcycle");
		vehicleMap.put("tricycle", "handicap");
		vehicleMap.put("electric", "electric");

		return vehicleMap.get(vehicleType);
	}

	public Map<Integer, List<Slot>> searchVehicleSlots(String vehicleModel) throws ManualException {

		Map<Integer, List<Slot>> tempMap = new HashMap<>();

		for (int i = 0; i < bluePrint.size(); i++) {

			tempMap.put(i, bluePrint.get(i).get(vehicleModel));

		}

		return tempMap;
	}

	int i = 0;
	
	public Ticket bookTicket(Ticket ticket,Customer customer) throws ManualException {

		String vehicleModel = vehicleModel(ticket.getVehicleType());

		int size = bluePrint.get(i).get(vehicleModel).size();

		if (size == 0) {
			i++;
		}

		if (size == 0 && i == bluePrint.size()) {
			i = 0;
			throw new ManualException("Parking Slot filled for " + vehicleModel);
		}

		Slot slot = bluePrint.get(i).get(vehicleModel).remove(0);
		
		ticket.setTicketId(ticketId());

		ticket.setTime(System.currentTimeMillis());

		ticket.setFloor(slot.getFloor());

		ticket.setSlot(slot.getSlotNumber());
		
		ticket.setElectricPanel(slot.isElectricPanel());

		ticketMap.put(ticket.getTicketId(), ticket);
		
		bookedSlot.add(slot);
		
		customerMap.put(customer.getCustomerId(),customer);
		
		vehicleMap.put(ticket.getVehicleNum(), ticket.getCustomerId());

		return ticket;
	}
	
	public String checkVehicle(String vehicleNum) throws ManualException {
		
		
		if(vehicleMap.containsKey(vehicleNum)) {
			
			return "Welcome "+customerMap.get(vehicleMap.get(vehicleNum)).getName();
		}
		return "New Customer";
	}

	public Map<Integer, Ticket> ticketList() throws ManualException {

		if (ticketMap.isEmpty()) {
			throw new ManualException("No Slots booked");
		}
		return ticketMap;
	}

	public Customer newCustomer(Customer customer,Ticket ticket) {
		
		ticket.setCustomerId(customer.getCustomerId());

		return customer;
	}
	
	public String getTicket(int ticketId) throws ManualException {
		
		if(!ticketMap.containsKey(ticketId)) {
			throw new ManualException("TicketId not found");
		}
		System.out.println(ticketMap);
		Ticket ticket = ticketMap.get(ticketId);
		
		int floor = ticket.getFloor();
		
		String vehicleModel = vehicleModel(ticket.getVehicleType());
		
		int slotNo = ticket.getSlot();
		
		boolean electricPanel = ticket.isElectricPanel();
		
		Slot slot = new Slot();
		
		slot.setFloor(floor);
		
		slot.setSlotNumber(slotNo);
		
		slot.setVehicleModel(vehicleModel);
		
		slot.setElectricPanel(electricPanel);
		
		bluePrint.get(floor).get(vehicleModel).add(slot);
		
		long time = (System.currentTimeMillis() - ticket.getTime())/1000/60;
		
		double wallet = customerMap.get(ticket.getCustomerId()).getWallet();
		
		
		
		if(time == 0 || time == 1) {
			wallet = wallet - 4.0;
			if(wallet < 0) {
				return -(wallet)+" $ needed";
			} 
		}
		if(time == 2) {
			wallet = wallet - 7.50;
			if(wallet < 0) {
				return -(wallet)+" $ needed";
			} 
		}
		if(time == 3) {
			wallet = wallet - 11.5;
			if(wallet < 0) {
				return -(wallet)+" $ needed";
			} 
		}
		if(time >3) {
			
			for(long i = time ; i >=3 ; i++) {
				wallet = wallet - 2;
			}
			wallet = wallet - 11.5;
			if(wallet < 0) {
				return -(wallet)+" $ needed";
			}
		}
			return "Thank You";
	}
	
	public Object addCustomer(Customer customer) throws ManualException {
		
		customer.setCustomerId(customerId());
		
		customerMap.put(customer.getCustomerId(), customer);
		
		if(customer.getWallet()<0) {
			throw new ManualException("Give Proper dollar");
		}
		
		return customer;
	}
	
	public Customer customerInfoPortal(int customerId) throws ManualException {
		
		if(customerMap.isEmpty()) {
			throw new ManualException("No Customer Info Found");
		}
		if(!customerMap.containsKey(customerId)) {
			throw new ManualException("Id not found");
		}
		
		return customerMap.get(customerId);
	}
	
	public String payCustomerPortal(int customerId, double wallet) throws ManualException {
		
		if(customerMap.isEmpty()) {
			throw new ManualException("No Customer Info Found");
		}
		if(!customerMap.containsKey(customerId)) {
			throw new ManualException("Id not found");
		}
		
		if(wallet < 0) {
			throw new ManualException("deposit proper wallet money");
		}
		
		Customer customer = customerMap.get(customerId);
		
		double balance = customer.getWallet();
		
		customer.setWallet(wallet+balance);
		
		balance = customer.getWallet();
		
		return "your new added wallet is "+ balance;
		
	}
	
	public Object premiumCustomer(Ticket ticket) throws ManualException {
	
		String vehicleModel = vehicleModel(ticket.getVehicleType());

		int size = bluePrint.get(i).get(vehicleModel).size();

		if (size == 0) {
			i++;
		}

		if (size == 0 && i == bluePrint.size()) {
			i = 0;
			throw new ManualException("Parking Slot filled for " + vehicleModel);
		}

		Slot slot = bluePrint.get(i).get(vehicleModel).remove(0);
		
		ticket.setTicketId(ticketId());
		
		String vehicleNum = ticket.getVehicleNum();
		
		int customerId = vehicleMap.get(vehicleNum);
		
		ticket.setCustomerId(customerId);

		ticket.setTime(System.currentTimeMillis());

		ticket.setFloor(slot.getFloor());

		ticket.setSlot(slot.getSlotNumber());
		
		ticket.setElectricPanel(slot.isElectricPanel());

		ticketMap.put(ticket.getTicketId(), ticket);
		
		bookedSlot.add(slot);
		
		return ticket;
		
	}
	
	public Map<String, Integer> premiumId() throws ManualException {
		
		if(vehicleMap.isEmpty()) {
			throw new ManualException("No premium customer's");
		}
		return vehicleMap;
	}
	
}
