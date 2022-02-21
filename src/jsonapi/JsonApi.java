package jsonapi;

import com.google.gson.Gson;

import jsonfile.JsonFile;

import org.json.simple.JSONObject;

import manualexception.ManualException;

import accountdeclare.*;

import helper.Helper;

public class JsonApi{
	JsonFile json = new JsonFile();
	JSONObject customer = new JSONObject();
	JSONObject account = new JSONObject();
	JSONObject	keyValues=new JSONObject();
	Helper helper = new Helper();
	Gson gson = new Gson();
	
	private int autoCustId = 1000;
	
	private int autoAccId = 2000;
	
	 @SuppressWarnings({ "unchecked" })
	private int generateCustId() throws ManualException 
	    {
	    	keyValues.put("customerKey", Integer.toString(++autoCustId));
	    	json.createJSON("KeyDetails.json", keyValues);
	    	return autoCustId;
	    }
	    
	    @SuppressWarnings({ "unchecked" })
	private int generateAccId() throws ManualException {
	    	
	    	keyValues.put("accountKey", Integer.toString(++autoAccId));
	    	json.createJSON("KeyDetails.json", keyValues);
	    	return autoAccId;
	    }
	    

	    @SuppressWarnings({ "unchecked" })
		public void putCustomer(CustomerDetails customerInstance) throws ManualException {
	    	
	    	helper.customerNullCheck(customerInstance);
	    	
	    	customerInstance.setCustId(generateCustId());
	    	
	    	int customerId = customerInstance.getCustId();
	    	
	    	String data = gson.toJson(customerInstance);
	    	
	    	customer.put(String.valueOf(customerId), data);
	    	
	    	json.createJSON("CustomerDetails.json", customer);
	    }
	    
	    
	    public JSONObject readCustomer() throws ManualException {
	    	
	    	return json.readJSON("CustomerDetails.json");
	    }
	    
	    public CustomerDetails getCustomerDetails(int customerId)throws ManualException
		{
			String data = (String) customer.get(String.valueOf(customerId));
			
			CustomerDetails customerObj=gson.fromJson(data, CustomerDetails.class);
			
			if(customerObj!=null)
			{
				return customerObj;
			}
			throw new ManualException("Unavailable");
		}
	    
		private void detectCustId(String customerId) throws ManualException 
		{
			if(customer.get(customerId)==null)
			{
				throw new ManualException("Existing customer ID needed to create account");
			}

	}
	   
	    public void putAccount(AccountDetails accountInstance)throws ManualException {
	    	
	    	helper.accountNullCheck(accountInstance);
	    	
	    	int customerId = accountInstance.getCustId();
	    	
	    	detectCustId(Integer.toString(customerId));
	    	
	    	accountInstance.setAccId(generateAccId());
	    	
	    	int accountId = accountInstance.getAccId();
	    	
	    	putAccount(customerId,accountId,accountInstance);
	    }
	    
	    @SuppressWarnings({ "unchecked" })
	    private void putAccount(int customerId, int accountId,AccountDetails accountInstance) throws ManualException{
	    	
	    	JSONObject jsonObj = (JSONObject)account.get(customerId);
	    	
	    	if(jsonObj==null) {
	    		
	    		jsonObj = new JSONObject();
	    		
	    		account.put(Integer.toString(customerId),jsonObj);
	    	}
	    	String data = gson.toJson(accountInstance);
	    	
	    	jsonObj.put(Integer.toString(accountId),data);
	    	
	    	json.createJSON("AccountDetails.json", account);
	    }
	  
	 public JSONObject readAccount() throws ManualException{
	    	
	    	return json.readJSON("AccountDetails.json");
	    }
   
    
  
    
    public void fetchCustomer() throws ManualException {
    	
    	customer = readCustomer();
    	
    	autoCustId = customer.size();
    }
    
   
    
    public void fetchAccount() throws ManualException {
    	
    	account = readAccount();
    	
    	autoAccId = account.size();
    }
  
	
	public JSONObject readKey()throws ManualException
	{
		return json.readJSON("KeyDetails.json");
	}
	
	
	public void fetchDetails() throws ManualException
	{
		keyValues=readKey();
		//System.out.println(keyValues);
		if(keyValues!=null)
		{
			customer=readCustomer();
			//System.out.println(customer);
			
			if(customer!=null)
			{
				String keyString=(String) keyValues.get("customerKey");
				
				autoCustId=Integer.parseInt(keyString);
			}
			account=readAccount();
			//System.out.println(account);
			if(account!=null)
			{
				String keyString=(String) keyValues.get("accountKey");
				
				autoAccId=Integer.parseInt(keyString);
			}
		}
	}
	
    
	public void accountStatus(int customerId,int accountId,boolean flag) throws ManualException
	{
		JSONObject jsonObj=(JSONObject) account.get(String.valueOf(customerId));
		if(jsonObj!=null)
		{
			String data=(String)jsonObj.get(String.valueOf(accountId));
			AccountDetails accountObj=(AccountDetails) gson.fromJson(data, AccountDetails.class);
			if(accountObj!=null)
			{
				accountObj.setStatus(flag);
				putAccount(customerId,accountId,accountObj);
			}
			else
			{
				throw new ManualException("NULL Account-Id");
			}
		}
		else
		{
			throw new ManualException("NULL Customer-Id");
		}
	}
	   
    public AccountDetails getAccount(int customerId,int accountId)throws ManualException{
    	
    	JSONObject jsonObj = (JSONObject) account.get(Integer.toString(customerId));
    	
    	if(jsonObj==null) {
    		
    		throw new ManualException("Given customer-ID is null");
    		
    	}
    	String data = (String)jsonObj.get(Integer.toString(accountId));
    	
    	AccountDetails accObj = (AccountDetails) gson.fromJson(data,AccountDetails.class);
    	
    	if(accObj!=null && accObj.isStatus()) {
    		
    		return accObj;
    	}
    	throw new ManualException("Account is De-activated or null data");
    }
    
    public String deposit(int customerId,int accountId,long amount)throws ManualException
	{
		AccountDetails accountObj=getAccount(customerId,accountId);
		
		if(accountObj.isStatus()) {
			
		accountObj.setBalance(accountObj.getBalance()+amount);
		
		putAccount(customerId,accountId,accountObj);
		
		return "Balance: "+accountObj.getBalance();
		}
		throw new ManualException("Account deactivated");
	}
    
	public String withdraw(int customerId,int accountId,long amount)throws ManualException
	{
		AccountDetails accountObj=getAccount(customerId,accountId);
		
		if(accountObj.isStatus()) {
		
		long balance=accountObj.getBalance();
		
		if(balance>amount)
		{
			accountObj.setBalance(balance-amount);
			
			putAccount(customerId,accountId,accountObj);
			
			return "Balance: " +accountObj.getBalance();
		}
		}
		throw new ManualException("Your balance is lower than the amount you want to withdraw");
	}
		
	
	public long getBalance(int customerId,int accountId) throws ManualException{
		
		AccountDetails accountObj=getAccount(customerId,accountId);
	
		if(accountObj.isStatus()) {
		
		return accountObj.getBalance();
		
		}
		
		throw new ManualException("Account deactivated");
	
	}
	

    public JSONObject entireCustomerAccounts(int customerId) {
    	
    	return (JSONObject) account.get(Integer.toString(customerId));
    }
    
	
    
}