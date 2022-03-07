package cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accountdeclare.Account;
import accountdeclare.Customer;
import manualexception.ManualException;
import utility.MapUtility;

public class CacheLayer
{
	Map<Integer,Customer> customerData=new HashMap<>();
	
	Map<Integer,Map<Integer,Account>> accountData=new HashMap<>();
	
	MapUtility util=new MapUtility();
	
	public void loadAccountDetails(Map<Integer,Map<Integer,Account>> accountDetails)
	{
		accountData.putAll(accountDetails);
	}
	
	public void loadCustomerDetails(Map<Integer,Customer> customerDetails)
	{
		customerData.putAll(customerDetails);
	}
	
	public boolean putCustomerDetails(int customerId,Customer customer)throws ManualException
	{
		util.putCustomerDetails(customerData,customerId,customer);
		
		System.out.println(customerData);
		
		return true;
	}
	
	public boolean putAccountDetails(int accountId,Account account)throws ManualException
	{
		util.putAccountDetails(accountData,accountId,account);
		
		return true;
	}
	
	public Customer getCustomerDetails(int customerId)throws ManualException
	{
		return util.getCustomerDetails(customerData,customerId);
	}
	
	public Account getAccountDetails(int customerId,int accountId)throws ManualException
	{
		return util.getAccountDetails(accountData,customerId, accountId);
	}

	public boolean setCustomerState(int customerId,boolean flag) throws ManualException
	{
		util.setCustomerState(customerData,customerId, flag);
		return true;
	}
	
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws ManualException
	{
		util.setAccountState(accountData,customerId, accountId, flag);
		return true;
	}
	
	public boolean deposit(int customerId,int accountId,double amount)throws ManualException
	{
		return util.deposit(accountData, customerId, accountId, amount);
	}
	
	public boolean withdraw(int customerId,int accountId,double amount)throws ManualException
	{
		return util.withdraw(accountData, customerId, accountId, amount);
	}
	
	public List<Account> getActiveAccounts(int customerId) throws ManualException
	{
		return util.getActiveAccounts(accountData, customerId);
	}
	
	public Map<Integer,Account> getCustomerAccounts(int customerId)throws ManualException
	{
		return util.getCustomerAccounts(accountData,customerId);
	}
}
