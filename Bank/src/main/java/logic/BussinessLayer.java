package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import accountdeclare.Account;
import accountdeclare.Customer;
import accountdeclare.User;
import cache.CacheLayer;
import manualexception.ManualException;
import persistencelayer.PersistenceLayer;

public class BussinessLayer 
{
	Properties property=new Properties();
	
	CacheLayer cache=new CacheLayer();
	
	PersistenceLayer interfaceObj;
	
	public BussinessLayer(boolean flag)
	{
		loadProperty();
		
		String path="";
		
		if(flag)
		{
			path=property.getProperty("DBPath");
		}
		else
		{
			path=property.getProperty("FilePath");
		}
		try 
		{
			Class<?> classObj=Class.forName(path);
			
			Object obj=classObj.getDeclaredConstructor().newInstance();
			
			interfaceObj=(PersistenceLayer)obj;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			fetchDetails();

			
		} catch (ManualException e) {
			
			e.printStackTrace();
		}
	}
	
	private void loadProperty()
	{
		property.setProperty("FilePath", "myfile.BankFile");
		
		property.setProperty("DBPath", "logic.DBLogic");
	}
	
	public void fetchDetails()throws ManualException
	{
		//System.out.println(interfaceObj.readCustomerDetails());
		
		cache.loadCustomerDetails(interfaceObj.readCustomerDetails());
		
		//System.out.println(interfaceObj.readAccountDetails());
		
		cache.loadAccountDetails(interfaceObj.readAccountDetails());
	}
	
	public boolean createStorage()throws ManualException
	{
		return interfaceObj.create();
	}
	
	public boolean putCustomerDetails(Customer customer)throws ManualException
	{
		customer=interfaceObj.putCustomerDetails(customer);
		
		cache.putCustomerDetails(customer.getCustomerId(), customer);
		
		return true;
	}
	
	public boolean updateCustomerDetails(Customer customer)throws ManualException{

		customer=interfaceObj.updateCustomerDetails(customer);
		
		cache.putCustomerDetails(customer.getCustomerId(), customer);
		
		return true;
		
	}
	
	public boolean putAccountDetails(Account account)throws ManualException
	{
		account=interfaceObj.putAccountDetails(account);
		
		cache.putAccountDetails(account.getAccountID(), account);
		
		return true;
	}
	
	public boolean updateAccountDetails(Account account)throws ManualException{
		
		account= interfaceObj.updateAccountDetails(account);
		
		cache.putAccountDetails(account.getAccountID(), account);
		
		return true;
	}
	
	public boolean setCustomerState(int customerId,boolean flag) throws ManualException
	{
		if(interfaceObj.setCustomerState(customerId, flag))
		{
			cache.setCustomerState(customerId, flag);
		}
		return true;
	}
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws ManualException
	{
		if(interfaceObj.setAccountState(customerId,accountId,flag))
		{
			cache.setAccountState(customerId,accountId,flag);
		}
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws ManualException
	{
		if(interfaceObj.deposit(customerId,accountId,amount))
		{
			cache.deposit(customerId,accountId,amount);
		}
		return true;
	}
	public boolean withdraw(int customerId,int accountId,double amount)throws ManualException
	{
		if(interfaceObj.withdraw(customerId,accountId,amount))
		{
			cache.withdraw(customerId,accountId,amount);
		}
		return true;
	}
	
	public Customer getCustomerDetails(int customerId)throws ManualException
	{
		return cache.getCustomerDetails(customerId);
	}
	
	public Account getAccountDetails(int customerId,int accountId)throws ManualException
	{
		return cache.getAccountDetails(customerId, accountId);
	}
	
	public List<Account> getActiveAccounts(int customerId) throws ManualException
	{
		return cache.getActiveAccounts(customerId);
	}
	
	public Map<Integer,Account> getCustomerAccounts(int customerId)throws ManualException
	{
		return cache.getCustomerAccounts(customerId);
	}
	
	public double getBalance(int customerId, int accountId)throws ManualException
	{
		Account account=getAccountDetails(customerId,accountId);
		
		return account.getBankBalance();
	}
	
	public User getUserDetails(int userId)throws ManualException
	{
		
		return interfaceObj.getUserDetails(userId);
	}
	
	public Map<Integer,Map<Integer,Account>> readAccountDetails()throws ManualException
	{
		return interfaceObj.readAccountDetails();
	}
	
	public Map<Integer,Customer> readCustomerDetails() throws ManualException{
		
		return interfaceObj.readCustomerDetails();
	}
	
	public int getAccountId()
	{
		return interfaceObj.getAccountId();
	}
	
	public List<Customer> getCustomerInfo() throws ManualException{
		
		List<Customer> list = new ArrayList<>();
		
		Map<Integer,Customer> mapObj = readCustomerDetails();
		
		for(Integer key: mapObj.keySet()) {
				
				Customer customerObj = mapObj.get(key);
				
				if(customerObj.getStatus()) {
					
					list.add(customerObj);
				}
			}
		
		return list;
		
		}
	
public List<Customer> getDeactivedCustomer() throws ManualException{
		
		List<Customer> list = new ArrayList<>();
		
		Map<Integer,Customer> mapObj = readCustomerDetails();
		
		for(Integer key: mapObj.keySet()) {
				
				Customer customerObj = mapObj.get(key);
				
				if(!customerObj.getStatus()) {
					
					list.add(customerObj);
				}
			}
		
		return list;
		
		}
	
	

	public List<Account> getInfo()throws ManualException
	{
		List<Account> list=new ArrayList<>();
		
		Map<Integer,Map<Integer,Account>> mapObj=readAccountDetails();
		
		for(Integer key:mapObj.keySet())
		{
			Map<Integer,Account> accountMap=mapObj.get(key);
			
			for(Integer iter:accountMap.keySet())
			{
				Account accountObj=accountMap.get(iter);
				
				if(accountObj.isStatus())
				{
					list.add(accountObj);
				}
			}
		}
		return list;
	}
	
	public List<Account> getDeactivatedAccount()throws ManualException
	{
		List<Account> list=new ArrayList<>();
		
		Map<Integer,Map<Integer,Account>> mapObj=readAccountDetails();
		
		for(Integer customerId:mapObj.keySet())
		{
			Map<Integer,Account> accountMap=mapObj.get(customerId);
			for(Integer accountId:accountMap.keySet())
			{
				Account accountObj=accountMap.get(accountId);
				if(!accountObj.isStatus())
				{
					list.add(accountObj);
				}
			}
		}
		return list;
	}
	
	public Map<Integer,Customer> getCustomerMap()throws ManualException
	{
		return interfaceObj.readCustomerDetails();
	}
	
	
	
}
