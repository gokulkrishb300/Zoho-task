package loginrunner;

import java.util.HashMap;
import java.util.Map;

import accountdeclare.AccountDetails;
import accountdeclare.CustomerDetails;
import api.Api;
import input.InputCenter;

import manualexception.ManualException;


public class ApiRunner {
	
		InputCenter input = new InputCenter();
		
	  	Api api = new Api();
	    
	  	
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
			
			api.customerMapping(customerDetails.getCustId(), customerDetails);
			
			   }
		}
		
		
    private void accountDetail(String about) throws ManualException {
    	
    	System.out.println(about);

    	int detectId = input.getInt("customer ID?");
		
	    api.detectCustId(detectId);
	        
	    	int noOfAcc = input.getInt("No of Account's : ");
	    	
	    	for(int i = 0 ; i < noOfAcc ; i++) {
	    		
	    	AccountDetails accountDetails = new AccountDetails();
	    	
	    		System.out.println(i+1+ " th account details");
	    		
	    		accountDetails.setCustId(detectId);
	    		
	    		accountDetails.setAccId(api.autoAccId());
	    		
	    		accountDetails.setAccNum(input.getLong("Account Number"));
	    		
	    		accountDetails.setAccName(input.getString("Account Type"));
	    		
	    		accountDetails.setBranch(input.getString("Branch"));
	    		
	    		api.accountMapping(accountDetails);
	    		
	    	}
	    	
	    }
    
        private void retrieveCustomerId(String about) throws ManualException {
        	
        	System.out.println(about);
        	
            System.out.println(api.retrieveCustomerId(input.getInt("Customer ID:")));
        }
		
        private void retrieveAccountInfo(String about) throws ManualException {
        	
        	System.out.println(about);
        	
        	System.out.println(api.retrieveAccountInfo(input.getInt("Customer ID: "),input.getInt("Account ID: ")));
        	
        }
        
        private void retrieveEntire(String about) throws ManualException {
        	
        	System.out.println(about);
        	
        	System.out.println(api.retrieveEntire(input.getInt("Customer ID:")));
        }
		public static void main(String[] args) throws ManualException{
			
			ApiRunner loginRunner = new ApiRunner();
			
			loginRunner.customerDetail("Customer Details");
			
			loginRunner.accountDetail("\nAccount Details");
	
			loginRunner.retrieveCustomerId("\nRetreive Customer Info using Customer ID:");
			
			loginRunner.retrieveAccountInfo("\nRetrieve Account Info:");
			
			loginRunner.retrieveEntire("\nRetrieve all about a Customer:");
				
			}
		  }
	
