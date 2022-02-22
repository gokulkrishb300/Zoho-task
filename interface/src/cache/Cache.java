package cache;

import java.util.HashMap;
import java.util.Map;

import account.Account;
import customer.Customer;
import manualexception.ManualException;
import maphelper.MapHelper;

public class Cache {

	Map<Integer,Customer> customerMap = new HashMap<>();
	Map<Integer,Map<Integer,Account>> accountMap = new HashMap<>();
	
	MapHelper helper = new MapHelper();
	
	public void setData(Map<Integer, Customer> customer, Map<Integer,Map<Integer,Account>> account) throws ManualException{
		customer = customerMap;
		account = accountMap;
	}
	
	public void addCustomer(int customerId , Customer customer) {
		helper.addCustomer(customerId, customer, customerMap);
	}
	
	public Customer getCustomer(int customerId) {
		return helper.getCustomer(customerId, customerMap);
	}
	
	public void addAccount(int accountId, Account account) {
		helper.addAccount(accountId, account, accountMap);
	}
	
	public Map<Integer,Account> getAccount(int customerId){
		return helper.getAccount(customerId, accountMap);
	}
	
	public void customerStatus(int customerId, int status) throws ManualException {
		helper.customerStatus(customerId, status, customerMap);
	}
	
	public void accountStatus(int customerId, int accountId, int status)throws ManualException{
		helper.accountStatus(customerId, accountId, status, accountMap);
	}
	
	public void deposit(int customerId, int accountId, int amount) throws ManualException {
		helper.deposit(customerId, accountId, amount, customerMap, accountMap);
	}
	
	public void withDrawal(int customerId, int accountId, int amount) throws ManualException{
		helper.withDrawal(customerId, accountId, amount, customerMap, accountMap);
	}
}
