package api;



import java.util.Map;

import accountdeclare.AccountDetails;
import accountdeclare.CustomerDetails;

import java.util.HashMap;

import manualexception.ManualException;
import helper.Helper;

public class Api{
	
	AccountDetails accountDetails = new AccountDetails();
	
	CustomerDetails customerDetails = new CustomerDetails();
	
	Helper helper = new Helper();
	
	int custIdGenerator = 1000;
	
	int accIdGenerator = 2000;
    
	static Map<Integer, CustomerDetails> customerMap = new HashMap<>();
	
	//static Map<Integer,AccountDetails> accountMap = new HashMap<>();
	
	static Map<Integer,Map<Integer, AccountDetails>> accountMap = new HashMap<>();
	

    
    public void customerMapping(int getCustomerId, Object customerInstance) throws ManualException{
       
         helper.mapNullCheck(customerMap);
         
         customerMap.put(getCustomerId,  (CustomerDetails) customerInstance);
    }
	
    public Map<Integer, Map<Integer,AccountDetails>> accountMapping(AccountDetails accountInstance) throws ManualException {
    	
    	int cusId=accountInstance.getCustId();
    	int accId=accountInstance.getAccId();
    	helper.mapNullCheck(accountMap);
    	
    	Map<Integer,AccountDetails> checkMapped = accountMap.get(cusId);
    	
    	if(checkMapped == null) {
    		
    		  checkMapped= new HashMap<>();
    		
    		  accountMap.put(cusId,checkMapped);
    	}
    	
    	checkMapped.put(accId,accountInstance);
    	
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
			throw new ManualException("ID didn't match");
		}

}
	public CustomerDetails retrieveCustomerId(int customerId) throws ManualException {
	 	   
	 	   return customerMap.get(customerId);
	    }
	 
	 
     public AccountDetails retrieveAccountInfo(int customerId,int accountId) throws ManualException {
    	 
    	 return  accountMap.get(customerId).get(accountId);
    	   
     }
     	
     public Map<Integer, AccountDetails> retrieveEntire(int customerId) throws ManualException {
    	 
    	 return  accountMap.get(customerId);
    	 
    	 
     }
	
	
}
