package runner;
import manualexception.ManualException;
import accountdeclare.Ticket;
import cache.*;
import input.InputCenter;

public class Runner {
	
	public static void vehicle() {
		
		System.out.println("1) van");
		System.out.println("2) car");
		System.out.println("3) truck");
		System.out.println("4) motorcycle");
		System.out.println("5) electric");
		System.out.println("6) tricycle");
		
	}
	public static void initial() {
		System.out.println();
		System.out.println("1) Show all floor details");
		System.out.println("2) Show available spots for my vehicle model");
		System.out.println("3) Get vehicle");
		System.out.println("4) exit");
		System.out.println();
	}
	
	public static void intermediate() {

		System.out.println("Ticket pay now or later");
		System.out.println("1) Now");
		System.out.println("2) Later");

	}
	
	public static void finale() {
		
		System.out.println("1) Cash");
		System.out.println("2) Card");

	}
	
public static void main(String[] args) throws ManualException {
	
	InputCenter input = new InputCenter();
	ApiLayer api = new ApiLayer();
	
	int noOfFloor = input.number("No.of.Floors");
	
	api.bluePrint(noOfFloor);
	
	boolean condition = true;
	
	while(condition) {
		
		initial();
		
		int choice = input.number("Enter here..");
		if(choice == 1) {
			System.out.println(api.showAllFloor());
		}
		
		if(choice == 2) {
			try {
				
				boolean cond = true;
				String urVehicleName = "";
				while(cond) {
					vehicle();
					int click = input.number("");
					
					
					
					if(click == 1) {
						urVehicleName = "van";
						System.out.println(api.searchMySpots(noOfFloor, urVehicleName));
						cond = false;
					}
					
					if(click == 2) {
						urVehicleName = "car";
						System.out.println(api.searchMySpots(noOfFloor, urVehicleName));
						cond = false;
					}
					
					if(click == 3) {
						urVehicleName = "truck";
						System.out.println(api.searchMySpots(noOfFloor, urVehicleName));
						cond = false;
					}
					if(click == 4) {
						
						urVehicleName = "motorcycle";
						System.out.println(api.searchMySpots(noOfFloor, urVehicleName));
						cond = false;
					}
					if(click == 5) {
						urVehicleName = "electric";
						System.out.println(api.searchMySpots(noOfFloor, urVehicleName));
						cond = false;
					}
					if(click == 6) {
						urVehicleName = "tricycle";
						System.out.println(api.searchMySpots(noOfFloor, urVehicleName));
						cond = false;	
					}
					
					if(click <0 || click > 6) {
						throw new ManualException("Select proper vehicle type");
					}
				}
				

				
					System.out.println("--- Slots availabe for your vehicle ---");
					
						Ticket ticket = new Ticket();
						
						int floor = input.number("which floor");
						
						if(floor < noOfFloor) {
							
						ticket.setFloor(floor);
						} 
						else {
							throw new ManualException("Enter available floor only");
						}
						
						
						boolean conditioner = true;
						
						while(conditioner) {
							
							intermediate();
							
							int choose = input.number("");
							
							if(choose > 2 || choose < 0) {
								System.out.println("- Enter available options only -");
							}
							
							if(choose == 1) {
								
								boolean conditioning = true;
								
								while(conditioning) {
									
									finale();
									
									int chose = input.number("");
									
									if(chose == 1) {
										api.reduceSpot(floor, urVehicleName);
										System.out.println( "$4 for the first hour, $3.5 for the second and third hours, and $2.5 for all the remaining hours");
										ticket.setPaidAmount(input.number("- pay ur dollar wisely -"));
										ticket.setStatus(true);
										conditioning = false;
									}
									
									if(chose == 2) {
										api.reduceSpot(floor, urVehicleName);
										System.out.println( "$4 for the first hour, $3.5 for the second and third hours, and $2.5 for all the remaining hours");
										ticket.setPaidAmount(input.number("- Swipe ur credit card and pay wisely -"));
										ticket.setStatus(true);
										conditioning = false;
									}
								}
								conditioner = false;
							}
							
							if(choose == 2) {
								api.reduceSpot(floor, urVehicleName);
								ticket.setPaidAmount(0);
								ticket.setStatus(false);
								conditioner = false;
							}
						}
						
						ticket.setVehicleModel(urVehicleName);
						
						System.out.println(api.ticket(ticket));
						
						System.out.println("-- Parking Slot Booked Successfully --");
					
			} catch(ManualException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(choice == 4) {
			condition = false;
			System.out.println("Have a nice day");
		}
	}
}
}
