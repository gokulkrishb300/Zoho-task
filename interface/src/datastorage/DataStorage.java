package datastorage;

import java.util.Map;

import account.Account;
import customer.Customer;
import manualexception.ManualException;

public interface DataStorage {

	//get customer map
	public Map<Integer,Customer> readCustomer() throws ManualException;
	
	//get account map
	public Map<Integer, Map<Integer,Account>> readAccount() throws ManualException;
	
	//add customer
	public int addCustomer(Customer customer) throws ManualException;
	
	//get customer
	public Customer getCustomer(int customerId) throws ManualException;
	
	//add account
	public int addAccount(Account account) throws ManualException;
	
	//get account
	public Map<Integer,Account> getAccount(int customerId) throws ManualException;
	
	//customer status
	public void customerStatus(int customerId, int status) throws ManualException;
	
	//account status
	public void accountStatus(int customerId, int accountId, int status) throws ManualException;
	
	//deposit
	public void deposit(int customerId, int accountId, int amount) throws ManualException;
	
	//withdraw
	public void withDrawal(int customerId, int accountId, int amount) throws ManualException;
	
}
