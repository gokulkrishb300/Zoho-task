package runner;
import cache.ApiLayer;
import input.InputCenter;
import accountdeclare.*;
public class Runner {
	
	public static void menu() {
		System.out.println("1) Book");
		System.out.println("2) Cancel");
		System.out.println("3) Show Booked Tickets");
		System.out.println("4) Show Available Tickets");
		System.out.println("5) Exit");
		System.out.println();
	}
	
	public static void berth() {
		System.out.println("1) lower");
		System.out.println("2) middle");
		System.out.println("3) upper");
		System.out.println("4) rac");
		System.out.println("5) sideUpper");
	}
	
public static void main(String[] args) {
	
	InputCenter input = new InputCenter();
	ApiLayer api = new ApiLayer();
	
	int compet = input.number("No.of Compet's : ");
	
	int waiting_list = input.number("Waiting-List limit : ");
	
	if(compet <1 || waiting_list < 1) {
		System.out.println("Give Proper Value");
		System.exit(0);
	}
	
	System.out.println(api.bluePrint(compet, waiting_list));
	
	String berth = "";
	
	boolean flag = true;	
	
	while(flag) {
		
		menu();
		int operation = input.number("input here..");
		
		if(operation == 1) {
			
			int noOfPassengers = input.number("Enter number of Passenger's");
			
			if(noOfPassengers < 1) {
				flag = false;
				System.out.println("Invalid number of passengers");
			}
			
			boolean berthB = true;
			
			while(berthB) {
				berth();
				int select = input.number("select berth here");
				
				if(select == 1) {
					berth = "LowerBerth";
					berthB = false;
				}
				
				if(select == 2) {
					berth = "MiddleBerth";
					berthB = false;
				}
				if(select == 3) {
					berth = "UpperBerth";
					berthB = false;
				}
				if(select == 4) {
					berth = "RAC";
					berthB = false;
				}
				if(select == 5) {
					berth = "SideUpperBerth";
					berthB = false;
				}
				if(select < 1 || select > 6) {
					flag = false;
					berthB = false;
					System.out.println("Invalid selection");
				}
			}
			
			for(int i = 0 ; i < noOfPassengers ; i++) {
				
				Passenger passenger = new Passenger();
				
				passenger.setName(input.stringInput("name please"));
				int age = input.number("age");
				passenger.setAge(age);
				passenger.setGender(input.stringInput("gender"));
				api.passenger(passenger, berth);
			}
			
			Ticket ticket = new Ticket();
			ticket.setNoOfPassenger(noOfPassengers);
			System.out.println(api.bookTicket(ticket));
		}
		if(operation == 2) {
			
		}
		if(operation == 3) {
			System.out.println(api.showBookedTickets());
		}
		if(operation == 4) {
			System.out.println(api.showAvailableTickets());
		}
		if(operation == 5) {
			flag = false;
			System.out.println("Have a nice day");
		}
	}
	
}
}
