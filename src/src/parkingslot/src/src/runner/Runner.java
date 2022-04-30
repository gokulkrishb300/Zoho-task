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
	
	public static void payment() {
		System.out.println("1) Cash");
		System.out.println("2) Credit");
		System.out.println();
	}

public static void main(String[] args) throws ManualException{
	
	ApiLayer api = new ApiLayer();
	InputCenter input = new InputCenter();
	
	String vehicleModel = "";
	
	long mobileNum = 0;
	
	
	int noOfFloor = input.number("No.Of Floor: ");
	
	int spot = input.number("No.Of Spots: ");
	
	System.out.println(api.bluePrint(noOfFloor,spot));
	
	
	boolean condition = true;
	

	while(condition) {
		
		initial();
		
		int select = input.number("");
		boolean flag = true;
		
		if(select == 1) {
			boolean conditioner = true;
			
			while(conditioner) {
				vehicle();
				int choose = input.number("");
				
				if(choose == 1) {
				   vehicleModel = api.vehicleModel("van");
				}
				
				if(choose == 2) {
					vehicleModel = api.vehicleModel("car");

				}
				
				if(choose == 3) {
					vehicleModel = api.vehicleModel("truck");

				}
				
				if(choose == 4) {
					
					vehicleModel = api.vehicleModel("motorcycle");
				}
				
				if(choose == 5) {
					
					vehicleModel = api.vehicleModel("electric");	
				}
				
				if(choose == 6) {
					
					vehicleModel = api.vehicleModel("tricycle");
				}
				if(choose >6) {
					conditioner = false;
					flag = false;
					System.out.println("Give Following Vehicles");
				}
				
				if(flag) {
				System.out.println("Verify through VehicleNo.");
				
				
				Ticket ticket = new Ticket();
				
				ticket.setVehicleNum(input.string(""));
	
				ticket.setVehicleType(vehicleModel);
				
				String vehicleCheck = api.checkVehicle(ticket.getVehicleNum());
					
				System.out.println(vehicleCheck);

				if(vehicleCheck.startsWith("Welcome")) {
					
					try {
					System.out.println(api.carNoBooking(ticket));
					conditioner = false;
					} catch(ManualException e) {
						conditioner = false;
						System.out.println(e.getMessage());
					}
				} 
				
				else  {
					
					mobileNum = input.longVal("");
				
					String mobileNoCheck = api.mobileNoCheck(mobileNum);
					
					System.out.println(mobileNoCheck);
					
					if(mobileNoCheck.startsWith("Welcome")) {
						
					
						try {
							System.out.println(api.mobileNoBooking(ticket,mobileNum));
							conditioner = false;
							
						
						} catch(ManualException e) {
							conditioner = false;
							System.out.println(e.getMessage());
						}
					}
				}
				
		
				if(conditioner) {
				Customer customer = new Customer();
				
                customer.setName(input.string("Name..."));
				
				customer.setMobile(mobileNum);
				
				try {
				System.out.println(api.addCustomer(customer));
				
				ticket.setCustomerId(customer.getCustomerId());
			
				System.out.println();
					
		     	System.out.println(api.newCustomerBooking(ticket,customer));
		     	
		    	conditioner = false;
				}
				catch(ManualException e) {
					conditioner = false;
					System.out.println(e.getMessage());
				}		
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
			try {
			System.out.println(api.premiumVehicle());
			}
			catch(ManualException e) {
				System.out.println(e.getMessage());
			}
		}
		if(select == 5) {
		try {
			int ticketId = input.number("Enter ticketId: ");
			String result = api.getTicket(ticketId);
			System.out.println(result);
			if(result.endsWith("needed")) {
				
				boolean flagger = true;
				
				while(flagger) {
					payment();
					int pay = input.number("");
					if(pay ==1 ) {
						double cash = input.doubleVal("enter cash ");
						System.out.println(api.cashPay(cash));
						flagger = false;
					}
					if(pay == 2) {
						String credit = input.string("Enter credit card no.");
						double amount = input.doubleVal("amount");
						System.out.println(api.creditPay(ticketId, amount, credit));
						flagger = false;
					}
				}
			}
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

