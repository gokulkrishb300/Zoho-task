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
	    
	  	Map<Object,Object> customerMap = api.createMap();
	  	
	  	Map<Object,Object> accountMap = api.createMap();
	  	
	  	Map<Object,Map<Object,Object>> doubleMap = api.createInsideMap();
	  	
		private void customerDetail(String about) throws ManualException {
			
			System.out.println(about);
			
			int noOfCust = input.getInt("No of Customer's : ");
			 
			for(int i =0 ; i < noOfCust; i++) {
				
			CustomerDetails customerDetails = new CustomerDetails();
				
			System.out.println(i+1 +" th customer details");
			
			customerDetails.setCustId(api.autoCustId());
			
			customerDetails.setName(input.getString("name "));
			
			customerDetails.setAge(input.getInt("age "));
			
			customerDetails.setGender(input.getString("gender "));
			
			customerDetails.setMobile(input.getLong("mobile "));
			
			api.mapping(customerMap, customerDetails.getCustId(), customerDetails);
			
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
	    		
	    		accountDetails.setCustId(detectId);
	    		
	    		accountDetails.setAccId(api.autoAccId());
	    		
	    		accountDetails.setAccNum(input.getLong("Account Number"));
	    		
	    		accountDetails.setAccName(input.getString("Account Type"));
	    		
	    		accountDetails.setBranch(input.getString("Branch"));
	    		
	    		api.mapping(accountMap,accountDetails.getAccId(),accountDetails);
	    		
	    		api.multiMapping(doubleMap,detectId, accountMap);
	    	}
	    	
	    }
           private void retrieveCustomerId(String about) throws ManualException {
        	   
        	   System.out.println(about);
        	   
        	   int key = input.getInt("Customer ID: ");
        	   
        	   System.out.println(customerMap.get(key));
           }
    
            private void retrieveCustomerAccInfo(String about) throws ManualException {
            	
            	System.out.println(about);
            	
         	int key = input.getInt("Customer ID: ");
         	
        	System.out.println(doubleMap.get(key));
        	
        	}
            
            private void retrieveAccountInfo(String about) throws ManualException {
            	
            	System.out.println(about);
            	
            	int key = input.getInt("Account ID: ");
            	
            	System.out.println(accountMap.get(key));
            }
            
            private void retrieveEntire(String about) throws ManualException{
            	
            	System.out.println(about);
            	
            	int key = input.getInt("Customer ID: ");
            	
            	System.out.println(customerMap.get(key));
            	
            	System.out.println(doubleMap.get(key));
            	
            }
		
		
		public static void main(String[] args) throws ManualException{
			
			LoginRunner loginRunner = new LoginRunner();
			
			loginRunner.customerDetail("Customer Details");
			
			loginRunner.accountDetail("\nAccount Details");
	
			loginRunner.retrieveCustomerId("\nRetrieve Customer Info using Customer ID:");
			
			loginRunner.retrieveCustomerAccInfo("\nRetrieve Customer Account Info Using Customer ID:");
			
			loginRunner.retrieveAccountInfo("\nRetrieve Account Info:");
			
			loginRunner.retrieveEntire("\nRetrieve all about a Customer:");
							
			}
		  }
	
