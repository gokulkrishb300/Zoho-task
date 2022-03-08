package persistencelayer;

import java.util.Map;

import accountdeclare.Account;
import accountdeclare.Customer;
import accountdeclare.User;
import manualexception.ManualException;

public interface PersistenceLayer 
{
	public boolean create()throws ManualException;
	
	public Customer putCustomerDetails(Customer customer)throws ManualException	;
	
	public Account putAccountDetails(Account account)throws ManualException;
	
	public Customer getCustomerDetails(int customerId)throws ManualException;
	
	public Account getAccountDetails(int customerId,int accountId)throws ManualException;
	
	public boolean setCustomerState(int customerId,boolean flag) throws ManualException;
	
	public boolean setAccountState(int customerId,int accountId,boolean flag) throws ManualException;
	
	public boolean deposit(int customerId,int accountId,double amount)throws ManualException;
	
	public boolean withdraw(int customerId,int accountId,double amount)throws ManualException;	
	
	public Map<Integer,Customer> readCustomerDetails()throws ManualException;
	
	public Map<Integer,Map<Integer,Account>> readAccountDetails()throws ManualException;
	
	public Map<String,Integer> validatePassword(int userId,String password)throws ManualException;

	public User getUserDetails(int userId)throws ManualException;
	
	public int getAccountId();
	
	
	
}