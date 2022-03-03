package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import accountdeclare.Account;
import accountdeclare.Customer;
import manualexception.ManualException;
import validateclass.Checker;

public class MapUtility 
{

	public void putCustomerDetails(Map<Integer,Customer> customerData,int customerId,Customer customerObj) throws ManualException
	{
		Checker.nullCheck(customerObj);
		customerData.put(customerId,customerObj);
	}
	
	
	public Customer getCustomerDetails(Map<Integer,Customer> customerData,int customerId)throws ManualException
	{
		Customer customerObj = customerData.get(customerId);
		if(customerObj!=null && customerObj.getStatus())
		{
			return customerObj;
		}
		throw new ManualException("Your account is De-Activated or No data available");
		
	}
	
	public void putAccountDetails(Map<Integer,Map<Integer,Account>> accountData,int accountId,Account accountObj) throws ManualException
	{
		Checker.nullCheck(accountObj);
		int customerId=accountObj.getCustomerID();
		Map<Integer,Account> mapObj=accountData.get(customerId);
		if(mapObj==null)
		{
			mapObj=new HashMap<>();
			accountData.put(customerId, mapObj);
		}
		mapObj.put(accountId,accountObj);
	}
	
	public Map<Integer,Account> getAllCustomerAccounts(Map<Integer,Map<Integer,Account>> accountData,int customerId)
	{
		return accountData.get(customerId);
	}
	
	public Account getAccountDetails(Map<Integer,Map<Integer,Account>> accountData,int customerId,int accountId)throws ManualException
	{
		Map<Integer,Account> mapObj=accountData.get(customerId);
		if(mapObj==null)
		{
			throw new ManualException("No data available for given Customer-Id");
		}
		Account accountObj=mapObj.get(accountId);
		if(accountObj!=null && accountObj.isStatus())
		{
			return accountObj;
		}
		throw new ManualException("Your account is De-Activated or No data available");
		
	}

	public void setAccountState(Map<Integer,Map<Integer,Account>> accountData,int customerId,int accountId,boolean flag) throws ManualException
	{
		Map<Integer,Account> mapObj=accountData.get(customerId);
		if(mapObj!=null)
		{
			Account accountObj=mapObj.get(accountId);
			if(accountObj!=null)
			{
				accountObj.setStatus(flag);
			}
			else
			{
				throw new ManualException("No data avail for given Account-Id");
			}
		}
		else
		{
			throw new ManualException("No data available for given Customer-Id");
		}
	}
	
	public List<Account> getActiveAccounts(Map<Integer,Map<Integer,Account>> accountData,int customerId) throws ManualException
	{
		List<Account> listObj=new ArrayList<>();
		
		Map<Integer,Account> mapObj=accountData.get(customerId);
		
		if(mapObj==null)
		{
			throw new ManualException("No data available for given Customer-Id");
		}
		for(Entry <Integer,Account> entry:mapObj.entrySet())
		{
			Account accountObj=entry.getValue();
			if(accountObj.isStatus())
			{
				listObj.add(accountObj);
			}
		}
		return listObj;
	}
	
	
	
	public void setCustomerState(Map<Integer,Customer> customerData,int customerId,boolean flag) throws ManualException
	{
		Customer customerObj=customerData.get(customerId);
		if(customerObj!=null)
		{
			customerObj.setStatus(flag);
		}
		else
		{
			throw new ManualException("No data available for given Customer-Id");
		}
		
	}
	
	public boolean deposit(Map<Integer,Map<Integer,Account>> accountData,int customerId,int accountId,double amount)throws ManualException
	{
		Account account=getAccountDetails(accountData,customerId,accountId);
		
		account.setBankBalance(account.getBankBalance()+amount);
		
		return true;
	}
	
	public boolean withdraw(Map<Integer,Map<Integer,Account>> accountData,int customerId,int accountId,double amount)throws ManualException
	{
		Account account=getAccountDetails(accountData,customerId,accountId);
		
		double balance=account.getBankBalance();
		
		if(balance>amount)
		{
			account.setBankBalance(balance-amount);
			
			return true;
		}
		throw new ManualException("Need Sufficient Balance to withdraw");
	}

	public Map<Integer, Account> getCustomerAccounts(Map<Integer,Map<Integer,Account>> accountData,int customerId) 
	{
		return accountData.get(customerId);
	}


	
}
