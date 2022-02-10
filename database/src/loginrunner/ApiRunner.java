package loginrunner;

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
			
			api.addCustomer(customerDetails.getCustId(), customerDetails);
			
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
	    		
	    		accountDetails.setAccType(input.getString("Account Type"));
	    		
	    		accountDetails.setBranch(input.getString("Branch"));
	    		
	    		api.addAccount(accountDetails);
	    		
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
        
        private void status(String about) throws ManualException {
        	
        	System.out.println(about);
        	
        	System.out.println(api.status(input.getInt("Customer ID: "),input.getInt("Account ID: "),input.getBoolean("Make active(true) or Inactive(false)")));
        }
        
        private void deposit(String about) throws ManualException {
        	
        	System.out.println(about);
        	
        	System.out.println(api.deposit(input.getInt("Customer ID: "),input.getInt("Account ID: "),input.getLong("how much :")));
        }
        
        private void withdraw(String about) throws ManualException {
        	
        	System.out.println(about);
        	
        	System.out.println(api.withdraw(input.getInt("Customer ID: "), input.getInt("Account ID: "),input.getLong("Withdrawal amount: ")));
        }
        
        private void balance(String about) throws ManualException {
        	
        	System.out.println(about);
        	
        	System.out.println(api.balance(input.getInt("Customer ID: "),input.getInt("Account ID: ")));
        }
        
		public static void main(String[] args) {
			
			ApiRunner loginRunner = new ApiRunner();
			
			try {
			loginRunner.customerDetail("Customer Details");
			
			loginRunner.accountDetail("\nAccount Details");
	
			loginRunner.retrieveCustomerId("\nRetreive Customer Info using Customer ID:");
			
			loginRunner.retrieveAccountInfo("\nRetrieve Account Info:");
			
			loginRunner.status("\nStatus of an account");
			
			loginRunner.deposit("\nDeposit to a customer");
			
			loginRunner.withdraw("\nWithdrawal from a customer");
			
			loginRunner.balance("\nBalance amount of a customer");
			
			loginRunner.retrieveEntire("\nRetrieve all about a Customer:");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			}
		  }
	
