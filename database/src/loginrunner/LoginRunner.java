package loginrunner;


import java.util.Map;
import api.Api;
import dbadvanced.AccountDetails;
import dbadvanced.CustomerDetails;
import input.InputCenter;

import manualexception.ManualException;


public class LoginRunner {
	
		InputCenter input = new InputCenter();
		
	  	Api api = new Api();
	    
	  	Map<Integer,CustomerDetails> customerMap = api.customerMap();
	  	
	  	Map<Integer,AccountDetails> accountMap = api.accountMap();
	  	
		private void customerDetail(String about) throws ManualException {
			
			System.out.println(about);
			
			
			int noOfCust = input.getInt("No of Customer's : ");
			 
			for(int i =0 ; i < noOfCust; i++) {
				
			CustomerDetails customerDetails = new CustomerDetails();
				
			System.out.println(i+1 +" th customer details");
			
			customerDetails.setName(input.getString("name "));
			
			customerDetails.setAge(input.getInt("age "));
			
			customerDetails.setGender(input.getString("gender "));
			
			customerDetails.setMobile(input.getLong("mobile "));
			
			
		
			customerMap.put(api.autoCustId(),customerDetails);
			
			   }
		}
		
		
    private void accountDetail(String about) throws ManualException {
    	
    	System.out.println(about);
    	
    	int detectId = input.getInt("customer ID?");
		
	    api.detectCustId(customerMap,detectId);
	    	
	    	int noOfAcc = input.getInt("No of Account's : ");
	    	
	    	for(int i = 0 ; i < noOfAcc ; i++) {
	    		
	    	AccountDetails accountDetails = new AccountDetails();
	    	
	    		System.out.println(i+1+ " th account details");
	    		
	    		accountDetails.setAccId(input.getInt("Account Id"));
	    		
	    		accountDetails.setAccNum(input.getLong("Account Number"));
	    		
	    		accountDetails.setAccName(input.getString("Account Name"));
	    		
	    		accountDetails.setBalance(input.getLong("Account Balance"));
	    		
	    		accountDetails.setBranch(input.getString("Branch"));
	    		
	    		accountMap.put(accountDetails.getId(), accountDetails);
	    			
	    	}
	    	
	    }
    
            private void retrieveCustomerId(String about) throws ManualException {
            	
            	System.out.println(about);
            	
         	int key = input.getInt("key: ");
         	
        	System.out.println(customerMap.get(key));
        	
        	}
            
            private void retrieveAccountId(String about) throws ManualException{
            	
            	System.out.println(about);
            	
            	int key = input.getInt("key: ");
            	
            	System.out.println(accountMap.get(key));
            	
            }
		
		
		public static void main(String[] args) throws ManualException{
			
			LoginRunner loginRunner = new LoginRunner();
			
			loginRunner.customerDetail("Customer Details");
			
			
			 
			loginRunner.accountDetail("Account Details");
	
			loginRunner.retrieveCustomerId("Retrieve Customer ID?");
		
			loginRunner.retrieveAccountId("Retrieve Account ID?");
				
				
			
			}
		  }
	
