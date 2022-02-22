package maphelper;

import java.util.HashMap;
import java.util.Map;

import account.Account;
import customer.Customer;
import manualexception.ManualException;

public class MapHelper {

	public void addCustomer(int customerId, Customer customer, Map<Integer,Customer> customerMap) {
		customerMap.put(customerId,customer);
	}
	
	public Customer getCustomer(int customerId, Map<Integer,Customer> customerMap) {
		return (Customer)customerMap.get(customerId);
	}
	
	public void addAccount(int accountId, Account account, Map<Integer,Map<Integer,Account>> accountMap) {
		
		int customerId = account.getCustomerId();
		
		Map<Integer,Account> instantMap = accountMap.get(customerId);
		
		if(instantMap == null) {
			
			instantMap = new HashMap<>();
			
			accountMap.put(customerId, instantMap);
		}
		
		instantMap.put(accountId, account);
	}
	
	public Map<Integer,Account> getAccount(int customerId, Map<Integer,Map<Integer,Account>> accountMap){
		
		return accountMap.get(customerId);
	}
	
	public void customerStatus(int customerId, int status, Map<Integer,Customer> customerMap) throws ManualException{
		Customer customer = getCustomer(customerId, customerMap);
		
		if(customer!=null) {
			if(status == 1) {
				customer.setStatus(true);
				addCustomer(customerId,customer,customerMap);
			} else {
				customer.setStatus(false);
				addCustomer(customerId,customer,customerMap);
			}
		} else {
			throw new ManualException("Customer non-existent");
		}
	}
	
	public void accountStatus(int customerId, int accountId, int status, Map<Integer,Map<Integer,Account>> accountMap) throws ManualException
{
		Map<Integer,Account> instantMap = getAccount(customerId,accountMap);
		if(accountMap!=null) {
			Account account = (Account) accountMap.get(accountId);
			
			if(account!=null) {
				if(status == 1) {
					account.setStatus(true);
				} else {
					account.setStatus(false);
				}
				instantMap.put(accountId,account);
				
				accountMap.put(customerId, instantMap);
			} else {
				throw new ManualException("Account non-existent");
			}
		} else {
			throw new ManualException("Customer non-existent");
		}
		}
	
	public void deposit(int customerId, int accountId, int amount, Map<Integer,Customer> customerMap,Map<Integer,Map<Integer,Account>> accountMap) throws ManualException {
		
		Customer customer = getCustomer(customerId, customerMap);
		
		if(customer.isStatus()==false) {
			throw new ManualException("Customer kept in in-active state");
		}
		
		Map<Integer,Account> instantMap = getAccount(customerId, accountMap);
		if(instantMap == null) {
			throw new ManualException("Account Information unprovided");
		}
		Account account = instantMap.get(accountId);
		if(account == null || account.isStatus()) {
			throw new ManualException("Account maybe deActivated or non-existent");
		}
		
		int balance = account.getBalance();
		
		int total = balance + amount;
		
		account.setBalance(total);
		
		instantMap.put(accountId,account);
		
		accountMap.put(customerId,instantMap);
	}
	
	public void withDrawal(int customerId, int accountId, int amount, Map<Integer,Customer> customerMap, Map<Integer,Map<Integer,Account>> accountMap) throws ManualException {
		
		Customer customer = getCustomer(customerId, customerMap);
		
		if(customer.isStatus() == false) {
			throw new ManualException("Customer kept in in-active state");
		}
		
		Map<Integer,Account> instantMap = getAccount(customerId, accountMap);
		
		if(instantMap == null) {
			throw new ManualException("Customer non-existent");
		}
		
		Account account = instantMap.get(accountId);
		
		if(account == null || account.isStatus()) {
			throw new ManualException("Account non-existent or deActivated");
		}
		
		int deposit = account.getBalance();
		
		if(deposit < amount) {
			throw new ManualException("Insufficient balance to withdraw from " +deposit);
		}
		
		int balance = deposit - amount;
		
		account.setBalance(balance);
		
		instantMap.put(accountId, account);
		
		accountMap.put(customerId, instantMap);
	}
}
