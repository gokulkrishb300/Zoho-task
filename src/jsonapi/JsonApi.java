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
	    	keyValues.put("CustomerKey", Integer.toString(autoCustId+1));
	    	
	    	return autoCustId++;
	    }
	    
	    @SuppressWarnings({ "unchecked" })
	private int generateAccId() throws ManualException {
	    	
	    	keyValues.put("AccountKey", Integer.toString(autoAccId+1));
	    	
	    	return autoAccId++;
	    }
	    

	    @SuppressWarnings({ "unchecked" })
		public void putCustomer(CustomerDetails customerInstance) throws ManualException {
	    	
	    	helper.customerNullCheck(customerInstance);
	    	
	    	customerInstance.setCustId(generateCustId());
	    	
	    	int customerId = customerInstance.getCustId();
	    	
	    	String data = gson.toJson(customerInstance);
	    	
	    	customer.put(String.valueOf(customerId), data);
	    }
	    
	    public CustomerDetails getCustomerDetails(int customerId)throws ManualException
		{
			String data = (String) customer.get(String.valueOf(customerId));
			
			CustomerDetails customerObj=gson.fromJson(data, CustomerDetails.class);
			
			if(customerObj!=null)
			{
				return customerObj;
			}
			throw new ManualException("Your account is De-Activated or No data Found");
		}
		
	    
	    public void storeCustomer()throws ManualException
		{
			json.createJSON("CustomerDetails.json", customer);
		}
	    
		private void detectCustId(String customerId) throws ManualException 
		{
			if(customer.get(customerId)==null)
			{
				throw new ManualException("Existing customer ID needed to create account");
			}

	}
	    @SuppressWarnings({ "unchecked" })
	    public void putAccount(AccountDetails accountInstance)throws ManualException {
	    	
	    	helper.accountNullCheck(accountInstance);
	    	
	    	detectCustId(Integer.toString(accountInstance.getCustId()));
	    	
	    	accountInstance.setAccId(generateAccId());
	    	
	    	int accountId = accountInstance.getAccId();
	    	
	    	JSONObject jsonObj = (JSONObject) account.get(Integer.toString(accountId));
	    	
	    	if(jsonObj==null) {
	    		
	    		jsonObj = new JSONObject();
	    		
	    		account.put(Integer.toString(accountInstance.getCustId()), jsonObj);
	    	}
	    	String data = gson.toJson(accountInstance);
	    	
	    	jsonObj.put(Integer.toString(accountId), data);
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
	    }
	    

	public void storeAccount()throws ManualException
		{
			json.createJSON("AccountDetails.json", account);
		}
	    
	    
    public JSONObject readCustomer() throws ManualException {
    	
    	return json.readJSON("customer.json");
    }
    
    public void fetchCustomer() throws ManualException {
    	
    	customer = readCustomer();
    	
    	autoCustId = customer.size();
    }
    
 
    
    public JSONObject readAccount() throws ManualException{
    	
    	return json.readJSON("account.json");
    }
    
    public void fetchAccount() throws ManualException {
    	
    	account = readAccount();
    	
    	autoAccId = account.size();
    }
    
   
    
	public void storeKey()throws ManualException
	{
		json.createJSON("KeyDetails.json", keyValues);
	}
	
	public JSONObject readKey()throws ManualException
	{
		return json.readJSON("KeyDetails.json");
	}
	
	public void fetchDetails() throws ManualException
	{
		keyValues=readKey();
		
		if(keyValues!=null)
		{
			customer=readCustomer();
			
			if(customer!=null)
			{
				String keyString=(String) keyValues.get("customerId");
				
				autoCustId=Integer.parseInt(keyString);
			}
			account=readAccount();
			
			if(account!=null)
			{
				String keyString=(String) keyValues.get("accountId");
				
				autoAccId=Integer.parseInt(keyString);
			}
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
    
    public boolean deposit(int customerId,int accountId,long amount)throws ManualException
	{
		AccountDetails accountObj=getAccount(customerId,accountId);
		
		accountObj.setBalance(accountObj.getBalance()+amount);
		
		putAccount(customerId,accountId,accountObj);
		
		return true;
	}
    
	public boolean withdraw(int customerId,int accountId,long amount)throws ManualException
	{
		AccountDetails accountObj=getAccount(customerId,accountId);
		
		long balance=accountObj.getBalance();
		
		if(balance>amount)
		{
			accountObj.setBalance(balance-amount);
			
			putAccount(customerId,accountId,accountObj);
			
			return true;
		}
		throw new ManualException("Your balance is lower than the amount you want to withdraw");
	}
	
	public long getBalance(int customerId,int accountId) throws ManualException{
		
		AccountDetails accountObj=getAccount(customerId,accountId);
		
		return accountObj.getBalance();
	}
	

    public JSONObject entireCustomerAccounts(int customerId) {
    	
    	return (JSONObject) account.get(Integer.toString(customerId));
    }
    
	
    
}