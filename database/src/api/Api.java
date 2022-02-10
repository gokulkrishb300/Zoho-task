package api;



import java.util.Map;

import accountdeclare.AccountDetails;
import accountdeclare.CustomerDetails;

import java.util.HashMap;

import manualexception.ManualException;
import helper.Helper;

public class Api{
	
	
	
	Helper helper = new Helper();
	
	int custIdGenerator = 1000;
	
	int accIdGenerator = 2000;
    
	static Map<Integer, CustomerDetails> customerMap = new HashMap<>();
	
	static Map<Integer,Map<Integer, AccountDetails>> accountMap = new HashMap<>();
	

    
    public void addCustomer(int getCustomerId, CustomerDetails customerInstance) throws ManualException{
       
         helper.mapNullCheck(customerMap);
         
         customerMap.put(getCustomerId, customerInstance);
    }
	
    public Map<Integer, Map<Integer,AccountDetails>> addAccount(AccountDetails accountInstance) throws ManualException {
    	
    	helper.mapNullCheck(accountMap);
    	
    	Map<Integer,AccountDetails> checkMapped = accountMap.get(accountInstance.getCustId());
    	
    	if(checkMapped == null) {
    		
    		  checkMapped= new HashMap<>();
    		
    		  accountMap.put(accountInstance.getCustId(),checkMapped);
    	}
    	
    	checkMapped.put(accountInstance.getAccId(),accountInstance);
    	
    	return accountMap;
    }
    
    
	public int autoCustId() {
		
		return custIdGenerator++;
		
	}
	
	public int autoAccId() {
		
		return accIdGenerator++;
		
	}
    
	public void detectCustId(int detectId) throws ManualException 
	{
		
		if(customerMap.get(detectId)==null)
		{
			throw new ManualException("Existing customer ID needed to create account");
		}

}
	
	public CustomerDetails retrieveCustomerId(int customerId) throws ManualException {
	 	   
	 	   return customerMap.get(customerId);
	    }
	 
	 
     public String retrieveAccountInfo(int customerId,int accountId) throws ManualException {
    	 
    	 Map<Integer,AccountDetails> customerAccount = accountMap.get(customerId);
    	 
    	 helper.mapNullCheck(customerAccount);
    	 
    	 AccountDetails  accountDetails=customerAccount.get(accountId);
    	 
    	 if(accountDetails!= null) {
    	 
    	 return  "Account :" + accountDetails;
    	 }
    	 else {
    		 return "Account didn't created";
    	 }
     }
     
     public String status(int customerId, int accountId, boolean status) throws ManualException {
    	 
         Map<Integer,AccountDetails> customerAccount = accountMap.get(customerId);
    	 
    	 helper.mapNullCheck(customerAccount);
    	 
    	 AccountDetails  accountDetails=customerAccount.get(accountId);
    	 
    	 if(accountDetails!= null) {
    	 
    	 accountDetails.setStatus(status);
    	 
    	 return "Account status made as: " +accountDetails.isStatus();
    	 
     }
    	 else {
    		 return "Account not created";
    	 }
    	 
     }
     
     	

     public String deposit(int customerId, int accountId, long deposit) throws ManualException {
    	 
         Map<Integer,AccountDetails> customerAccount = accountMap.get(customerId);
    	 
    	 helper.mapNullCheck(customerAccount);
    	 
    	 AccountDetails  accountDetails=customerAccount.get(accountId);
    	 
    	 if(accountDetails!= null) {
    	 
    	      if(accountDetails.isStatus()) {
    	 
    	      accountDetails.setDeposit(deposit);
    	 
    	      accountDetails.setBalance(accountDetails.getBalance()+accountDetails.getDeposit());
    	 
    	      return "Deposit amount: " + accountDetails.getDeposit()+"\nBalance: "+accountDetails.getBalance();
    	      } else {
    		 return "Account Inactivated";
    	      }
    	 }
    	 else {
    		 return "Account not created";
    	 }
     }
     
     public String withdraw(int customerId, int accountId, long withdraw) throws ManualException {
    	
         Map<Integer,AccountDetails> customerAccount = accountMap.get(customerId);
    	 
    	 helper.mapNullCheck(customerAccount);
    	 
    	 AccountDetails  accountDetails=customerAccount.get(accountId);
    	 
    	 if(accountDetails!= null) {

    		 if(accountDetails.isStatus()) {

    			 accountDetails.setWithDraw(withdraw);

    			 if(accountDetails.getBalance()>=accountDetails.getWithDraw()) {

    				 accountDetails.setBalance(accountDetails.getBalance()-accountDetails.getWithDraw());
    			 }else {

    				 return "Insufficient balance to withdraw";
    			 }

    			 return "Withdrawal amount: " + accountDetails.getWithDraw()+"\nBalance: "+accountDetails.getBalance();
    		 }
    		 else {
    			 return "Account Inactivated";
    		 }
    	 }else {
    		 return "Account not created";
    	 }
     
}
     
     public String balance(int customerId, int accountId) throws ManualException {
     
    	 
    	 Map<Integer,AccountDetails> customerAccount = accountMap.get(customerId);
    	 
    	 helper.mapNullCheck(customerAccount);
    	 
    	 AccountDetails  accountDetails=customerAccount.get(accountId);
    	 
    	 if(accountDetails != null ) {
    	 
    	     if(accountDetails.isStatus()) {
    	 
    	     return "Balance: " + accountDetails.getBalance();
             }
             else {
    		 return "Account Inactivated";
    	      }
    	 }
    	 else {
    		 return "Account not created";
    	 }
    	 
 }
     
     public Map<Integer, AccountDetails> retrieveEntire(int customerId) throws ManualException {
    	 
    	 return accountMap.get(customerId);
     }
     
    
}
