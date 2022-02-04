package loginrunner;


import java.util.HashMap;
import java.util.Map;

import dbadvanced.AccountDetails;
import dbadvanced.CustomerDetails;
import input.InputCenter;

import manualexception.ManualException;


public class LoginRunner {
	
		InputCenter input = new InputCenter();
		
		CustomerDetails customerDetails = new CustomerDetails();
		
		AccountDetails accountDetails = new AccountDetails();
		
	    Map<Integer,Object> map = new HashMap<>();
		
	  	int generator=1000;
	    
	    private int autoGenerateIdCust() {
	    	
	    	customerDetails.setId(generator);
	    	
	    	return generator++;
	    }
	    
	    private int autoGenerateIdAcc() {
	    	
	    	accountDetails.setId(generator);
	    	
	    	return generator++;
	    }
	    
		private void customerDetail() throws ManualException {
			
			int noOfCust = input.getInt("No of Customer's : ");

			for(int i =0 ; i < noOfCust; i++) {
				
			System.out.println(i+1 +" th customer details");
			
			autoGenerateIdCust();
			
			customerDetails.setName(input.getString("name "));
			
			customerDetails.setAge(input.getInt("age "));
			
			customerDetails.setGender(input.getString("gender "));
			
			customerDetails.setMobile(input.getLong("mobile "));
		
			map.put(customerDetails.getId(), customerDetails);
			
			   }
			
            int key = input.getInt("key: ");
    		
    		System.out.println(map);
    		
    		System.out.println(map.get(key));
		}
		
    private void accountDetail() throws ManualException {
	    	
	    	int noOfAcc = input.getInt("No of Account's : ");
	    	
	    	for(int i = 0 ; i < noOfAcc ; i++) {
	    		
	    		System.out.println(i+1+ " th account details");
	    		autoGenerateIdAcc();
	    		
	    		accountDetails.setAccNum(input.getLong("Account Number"));
	    		
	    		accountDetails.setAccName(input.getString("Account Name"));
	    		
	    		accountDetails.setBalance(input.getLong("Account Balance"));
	    		
	    		accountDetails.setBranch(input.getString("Branch"));
	    		
	    		map.put(accountDetails.getId(), accountDetails);
	    		
	    	}
	    	int key = input.getInt("key: ");
    		
    		System.out.println(map);
    		
    		System.out.println(map.get(key));
	    }
    
//    private void retrieveKey() throws ManualException {
//    	int key = input.getInt("key: ");
//    	System.out.println(map);
//    	System.out.println(map.get(key));
//    	
//    }
		
		
		public static void main(String[] args) throws ManualException{
			
			LoginRunner loginRunner = new LoginRunner();
			
			//InputCenter input = new InputCenter();

		//int caseNo = input.getInt("Case No.");
		
		//switch(caseNo) {
		//case 1:
			loginRunner.customerDetail();
	
			loginRunner.accountDetail();
		//	break;
//		case 3:
//			loginRunner.retrieveKey();
//			break;
		//default:
			//System.out.println("-----No case-----");
		   }
		//}
	}
