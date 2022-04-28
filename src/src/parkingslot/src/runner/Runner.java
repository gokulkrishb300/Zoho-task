package runner;

import manualexception.ManualException;
import accountdeclare.Customer;
import accountdeclare.Ticket;
import cache.*;
import input.InputCenter;

public class Runner {
	
	public static void initial() {
		System.out.println();

		System.out.println("1) Entry");
		System.out.println("2) Show Booked Tickets");
		System.out.println("3) Customer Info Panel");
		System.out.println("4) Premium Vehicles");
		System.out.println("5) Customer Exit");
		System.out.println("6) BluePrint");
		System.out.println("7) Exit");
		System.out.println();
	}
	public static void vehicle() {
		
		System.out.println("1) van");
		System.out.println("2) car");
		System.out.println("3) truck");
		System.out.println("4) motorcycle");
		System.out.println("5) electric");
		System.out.println("6) tricycle");
		
	}
	
public static void main(String[] args) throws ManualException{
	
	ApiLayer api = new ApiLayer();
	InputCenter input = new InputCenter();
	
	String vehicleModel = "";
	String vehicleType = "";
	
	int noOfFloor = input.number("No.Of Floor: ");
	int spot = input.number("No.Of Spots: ");
	
	System.out.println(api.bluePrint(noOfFloor,spot));
	
	
	boolean condition = true;
	

	while(condition) {
		
		initial();
		
		int select = input.number("");
		
		if(select == 1) {
			boolean conditioner = true;
			while(conditioner) {
				vehicle();
				int choose = input.number("");
				
				if(choose == 1) {
					vehicleType = "van";
				   vehicleModel = api.vehicleModel(vehicleType);
				   System.out.println(api.searchVehicleSlots(vehicleModel));
				
				}
				
				if(choose == 2) {
					vehicleType = "car";
					vehicleModel = api.vehicleModel(vehicleType);
					System.out.println(api.searchVehicleSlots(vehicleModel));
				
				}
				
				if(choose == 3) {
					vehicleType = "truck";
					vehicleModel = api.vehicleModel(vehicleType);
					System.out.println(api.searchVehicleSlots(vehicleModel));
					
				}
				
				if(choose == 4) {
					vehicleType = "motorcycle";
					vehicleModel = api.vehicleModel(vehicleType);
					System.out.println(api.searchVehicleSlots(vehicleModel));
					
				}
				
				if(choose == 5) {
					vehicleType = "electric";
					vehicleModel = api.vehicleModel(vehicleType);
					System.out.println(api.searchVehicleSlots(vehicleModel));
					
				}
				
				if(choose == 6) {
					vehicleType = "tricycle";
					vehicleModel = api.vehicleModel(vehicleType);
					System.out.println(api.searchVehicleSlots(vehicleModel));
				
				}
				if(choose >6) {
					conditioner = false;
					System.out.println("Give Following Vehicles");
				}
			
				
				
				Ticket ticket = new Ticket();
				
				ticket.setVehicleNum(input.string("Vehicle No."));
	
				ticket.setVehicleType(vehicleType);
			
				String vehicleCheck = api.checkVehicle(ticket.getVehicleNum());
				
				if(vehicleCheck.startsWith("Welcome")) {
					
					System.out.println(vehicleCheck);
					
					try {
					System.out.println(api.premiumCustomer(ticket));
					} catch(ManualException e) {
						System.out.println(e.getMessage());
					}
					
					
				} else {
				
				Customer customer = new Customer();
				
                customer.setName(input.string("Name..."));
				
				customer.setMobile(input.longVal("Mobile number..."));
				
				customer.setWallet(input.doubleVal("deposit..."));
				
				try {
				api.addCustomer(customer);
				
				System.out.println(api.newCustomer(customer,ticket));
			
				System.out.println();
					
		     	System.out.println(api.bookTicket(ticket,customer));
				}
				catch(ManualException e) {
					System.out.println(e.getMessage());
				}		
			}
			}
		}
		if(select == 2) {
			try {
			System.out.println(api.ticketList());
			} catch(ManualException e) {
				System.out.println(e.getMessage());
			}
		}
		if(select == 3) {
			int customerId = input.number("Enter customerId");
			try {
				
				System.out.println(api.customerInfoPortal(customerId));
				
				boolean condit = true;
				while(condit) {
					System.out.println("1) Would you like to deposit ?");
					System.out.println("2) Exit the Portal");
					System.out.println();
					int number = input.number("Enter here");
					if(number == 1) {
						double wallet = input.doubleVal("Enter dollar");
						System.out.println(api.payCustomerPortal(customerId, wallet));
					}
					if(number == 2) {
						condit = false;
						System.out.println("Have a nice day");
					}
				}
				
			}
			catch(ManualException e) {
				System.out.println(e.getMessage());
			}
	
		}
		if(select == 4) {
			System.out.println(api.premiumVehicle());
		}
		if(select == 5) {
		try {
			System.out.println(api.getTicket(input.number("Enter ticketId: ")));
		}catch(ManualException e) {
			System.out.println(e.getMessage());
		}
		}
		
		if(select == 6) {
			System.out.println(api.showBluePrint());
			
		}
		
		if(select >6) {
			condition = false;
			System.out.println("Have a nice day");
		}
		}
	
		
	}

	  }

