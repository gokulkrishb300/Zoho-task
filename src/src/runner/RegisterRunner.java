package runner;
import java.util.*;

import accountdeclare.Customer;
import accountdeclare.Register;
import input.InputCenter;
public class RegisterRunner {

	public static void main(String[] args) {
		
		int autoUserId = 1000;
		int autoPwd = 100;
	
	Scanner sc = new Scanner(System.in);
	InputCenter input = new InputCenter();
	Register register = new Register();
	Customer customer = new Customer();

		String choice = input.string("--- Login Or Register ---");
	
		Map<Map<Integer,Integer>,Object> loginDetails = new HashMap<>();
		
		Map<Integer,Integer> login = new HashMap<>();
		
	
		
		if(choice.equals("Register")) {
			
			System.out.println("Fill the  following form to register a new account");
		
		
			customer.setName(input.string("Your Name       "));
			
			customer.setAddress(input.string("Address         "));
			
		    customer.setEmail_ID(input.string("Email-ID        "));
		    
		    customer.setMobile(input.longVal("Mobile Number  "));
	
			register.setUserID(autoUserId);
			
			register.setPassword(autoPwd);
			
			login.put(register.getUserID(), register.getPassword());
			
			loginDetails.put(login, customer);
			
		}
		
//		if(flag == 1) {
//	    System.exit(0);
//		}
		
		System.out.println("User "+customer.getName()+" has been created");
		
		System.out.println(register);
		
		int userId = input.number("Enter userID");
		
		if(login.containsKey(userId)) {
			if(login.get(userId) == input.number("Enter password")) {
				System.out.println(loginDetails.get(login));
			} else {
				System.out.println("Wrong Password");
			}
		} else {
			System.out.println("UserId Not Found");
		}
			
		
		

        
        sc.close();
	}
	

}
