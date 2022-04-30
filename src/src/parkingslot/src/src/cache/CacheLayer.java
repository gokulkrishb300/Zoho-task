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

	Map<Integer, Customer> customerMap = new HashMap<>();

	Map<String, Integer> vehicleMap = new HashMap<>();

	Map<Long, Integer> mobileNoMap = new HashMap<>();

	private int ticketId = 1000;

	private int ticketId() {
		return ++ticketId;
	}

	private int customerId = 100;

	private int customerId() {

		return ++customerId;
	}

	double charge = 0;

	private int floorSize = 0;

	public Map<Integer, Map<String, List<Slot>>> bluePrint(int floor, int spot) {

		floorSize = floor;

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

	public String checkVehicle(String vehicleNum) {

		if (vehicleMap.containsKey(vehicleNum)) {

			return "Welcome " + customerMap.get(vehicleMap.get(vehicleNum)).getName();
		}
		return "Check through mobile No.";
	}

	public String mobileNoCheck(long mobile) {

		if (mobileNoMap.containsKey(mobile)) {
			return "Welcome " + customerMap.get(mobileNoMap.get(mobile)).getName();
		}
		return "The following one is a New Customer";
	}

	public Map<Integer, Ticket> ticketList() throws ManualException {

		if (ticketMap.isEmpty()) {
			throw new ManualException("No Slots booked");
		}
		return ticketMap;
	}

	public Customer addCustomer(Customer customer) throws ManualException {

		customer.setCustomerId(customerId());

		customerMap.put(customer.getCustomerId(), customer);

		if (customer.getWallet() < 0) {
			throw new ManualException("Give Proper dollar");
		}

		return customer;
	}

	public Customer newCustomer(Customer customer, Ticket ticket) {

		ticket.setCustomerId(customer.getCustomerId());

		return customer;
	}

	public String getTicket(int ticketId) throws ManualException {

		if (!ticketMap.containsKey(ticketId)) {

			throw new ManualException("TicketId not found");
		}

		Ticket ticket = ticketMap.get(ticketId);

		int floor = ticket.getFloor();

		String vehicleModel = ticket.getVehicleType();

		int slotNo = ticket.getSlot();

		boolean electricPanel = ticket.isElectricPanel();

		Slot slot = new Slot();

		slot.setFloor(floor);

		slot.setSlotNumber(slotNo);

		slot.setVehicleModel(vehicleModel);

		slot.setElectricPanel(electricPanel);

		bluePrint.get(floor).get(vehicleModel).add(slot);

		long time = (System.currentTimeMillis() - ticket.getEntryTime()) / 1000 / 60;

		Customer customer = customerMap.get(ticket.getCustomerId());

		double wallet = customer.getWallet();

		double amount = wallet;

		double fee = 0.0;

		if (time == 0 || time == 1) {
			fee = 4.0;
			amount = amount - fee;
			customer.setWallet(amount);

			if (amount < 0) {
				charge = fee;
				customer.setWallet(wallet);
				return -(amount) + " $ needed";
			}
		}
		if (time == 2) {
			fee = 7.5;
			amount = amount - fee;
			customer.setWallet(amount);
			if (amount < 0) {
				charge = fee;
				customer.setWallet(wallet);
				return -(amount) + " $ needed";
			}
		}
		if (time == 3) {
			fee = 11.5;
			amount = amount - fee;
			customer.setWallet(amount);
			if (amount < 0) {
				charge = fee;
				customer.setWallet(wallet);
				return -(amount) + " $ needed";
			}
		}
		if (time > 3) {
			for (long i = time; i > 3; i--) {
				amount = amount - 2.0;
			}
			amount = amount - 11.5;
			fee = amount;
			customer.setWallet(amount);
			if (amount < 0) {
				charge = fee;
				customer.setWallet(wallet);
				return -(amount) + " $ needed";
			}
		}
		wallet = customer.getWallet();
		return fee + " $ deducted for " + time + " hours" + "\n" + "Your new wallet balance is " + wallet + "$.\n"
				+ " Thank You";
	}

	public Customer customerInfoPortal(int customerId) throws ManualException {

		if (customerMap.isEmpty()) {
			throw new ManualException("No Customer Info Found");
		}
		if (!customerMap.containsKey(customerId)) {
			throw new ManualException("Id not found");
		}

		return customerMap.get(customerId);
	}

	public String payCustomerPortal(int customerId, double wallet) throws ManualException {

		if (customerMap.isEmpty()) {
			throw new ManualException("No Customer Info Found");
		}
		if (!customerMap.containsKey(customerId)) {
			throw new ManualException("Id not found");
		}

		if (wallet < 0) {
			throw new ManualException("deposit proper wallet money");
		}

		Customer customer = customerMap.get(customerId);

		double balance = customer.getWallet();

		customer.setWallet(wallet + balance);

		balance = customer.getWallet();

		return "your new added wallet is " + balance;

	}

	public Ticket newCustomerBooking(Ticket ticket, Customer customer) throws ManualException {

		localMethod(ticket);

		int customerId = customer.getCustomerId();

		mobileNoMap.put(customer.getMobile(), customerId);

		customerMap.put(customerId, customer);

		vehicleMap.put(ticket.getVehicleNum(), customerId);

		return ticket;
	}

	public Ticket carNoBooking(Ticket ticket) throws ManualException {

		localMethod(ticket);

		String vehicleNum = ticket.getVehicleNum();

		int customerId = vehicleMap.get(vehicleNum);

		ticket.setCustomerId(customerId);

		ticketMap.put(ticket.getTicketId(), ticket);

		return ticket;

	}

	public Ticket mobileNoBooking(Ticket ticket, Long mobile) throws ManualException {

		localMethod(ticket);

		int customerId = mobileNoMap.get(mobile);

		ticket.setCustomerId(customerId);

		ticketMap.put(ticket.getTicketId(), ticket);

		return ticket;

	}

	public Map<String, Integer> premiumId() throws ManualException {

		if (vehicleMap.isEmpty()) {
			throw new ManualException("No premium customer's");
		}
		return vehicleMap;
	}

	private void slot(int i, Slot slot, Ticket ticket, String vehicleModel) {

		slot = bluePrint.get(i).get(vehicleModel).remove(0);

		ticket.setTicketId(ticketId());

		ticket.setEntryTime(System.currentTimeMillis());

		ticket.setFloor(slot.getFloor());

		ticket.setSlot(slot.getSlotNumber());

		ticket.setElectricPanel(slot.isElectricPanel());

		ticketMap.put(ticket.getTicketId(), ticket);
	}

	private void localMethod(Ticket ticket) throws ManualException {

		int i = 0;

		Slot slot = null;

		String vehicleModel = ticket.getVehicleType();

		int size = bluePrint.get(i).get(vehicleModel).size();

		if (size == 0) {
			i++;
		}

		if (bluePrint.get(floorSize - 1).get(vehicleModel).isEmpty()) {

			if (i < floorSize && size > 0) {
				slot(i, slot, ticket, vehicleModel);
			} else {
				throw new ManualException("Parking Slot filled for " + vehicleModel + " in all floor's");
			}
		} else {
			slot(i, slot, ticket, vehicleModel);
		}
	}

	public String cashPay(double cash) throws ManualException {

		if (cash < 0) {
			throw new ManualException("Invalid Cash");
		}

		double balance = charge - cash;

		if (balance > 0.0) {
			return "Pay Proper Balance";
		}

		charge = 0;

		return "Cash Payment Succeed" + "\n" + "Remaining balance " + -(balance);

	}

	public String creditPay(int ticketId, double cash, String creditNo) throws ManualException {

		String credit = String.valueOf(creditNo);

		if (credit.length() != 16) {
			throw new ManualException("Invalid credit card");
		}

		if (cash < 0) {
			throw new ManualException("Invalid Cash");
		}

		double balance = charge - cash;

		if (balance > 0.0) {
			return "Pay Proper Balance";
		}

		Ticket ticket = ticketMap.get(ticketId);

		int customerId = ticket.getCustomerId();

		payCustomerPortal(customerId, cash);

		getTicket(ticketId);

		charge = 0;

		return "Credit card Payment Succeed";

	}
}
