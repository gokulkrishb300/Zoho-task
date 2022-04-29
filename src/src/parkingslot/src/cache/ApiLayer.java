package cache;

import java.util.List;
import java.util.Map;

import accountdeclare.Customer;
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
	
//	public Map<Integer, List<Slot>> searchVehicleSlots(String vehicleModel) throws ManualException {
//		return cache.searchVehicleSlots(vehicleModel);
//	}
	
	public Ticket newCustomerBooking(Ticket ticket,Customer customer) throws ManualException {
		return cache.newCustomerBooking(ticket,customer);
	}
	
	public Map<Integer, Ticket> ticketList() throws ManualException {
		
		return cache.ticketList();
	}
	public Customer newCustomer(Customer customer,Ticket ticket) {
		return cache.newCustomer(customer,ticket);
	}
	
	public Customer customerInfoPortal(int customerId) throws ManualException {
		return cache.customerInfoPortal(customerId);
	}
	
	public String getTicket(int ticketId) throws ManualException {
		return cache.getTicket(ticketId);
	}
	
	public String payCustomerPortal(int ticketId, double wallet) throws ManualException {
		return cache.payCustomerPortal(ticketId, wallet);
	}
	
	public String checkVehicle(String vehicleNum)  {
		return cache.checkVehicle(vehicleNum);
	}
	
	public String mobileNoCheck(long mobile){
		return cache.mobileNoCheck(mobile);
	}
	
	public Object addCustomer(Customer customer) throws ManualException {
		return cache.addCustomer(customer);
	}
	
	public Object carNoBooking(Ticket ticket) throws ManualException {
		return cache.carNoBooking(ticket);
	}
	
	public Map<String, Integer> premiumVehicle() throws ManualException {
		return cache.premiumId();
	}
	
	public Ticket mobileNoBooking(Ticket ticket , long mobile) throws ManualException {
		return cache.mobileNoBooking(ticket, mobile);
	}
	
	public String cashPay(double cash) throws ManualException {
		return cache.cashPay(cash);
	}
	
	public String creditPay(int ticketId, double cash,String creditNo) throws ManualException {
		return cache.creditPay(ticketId, cash, creditNo);
	}
}
