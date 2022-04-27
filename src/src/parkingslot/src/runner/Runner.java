package runner;

import manualexception.ManualException;
import accountdeclare.Ticket;
import cache.*;
import input.InputCenter;

public class Runner {
	
	public static void initial() {
		System.out.println();

		System.out.println("1) Book Slot for following vehicle type");
		System.out.println("2) Show Booked Tickets");
		System.out.println("3) Get TicketId");
		System.out.println("4) Customer Return");
		System.out.println("5) BluePrint");
		System.out.println("6) exit");
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
				
				int floor = input.number("Enter floor no");
				
			//1	System.out.println(api.bookTicket(floor, vehicleModel));
				
				
			}
		
		
		if(select == 5) {
			System.out.println(api.showBluePrint());
			
		}
			
		}
	
		
	}

	  }

