package cache;

import java.util.List;
import java.util.Map;

import accountdeclare.*;

public class APILayer {

	CacheLayer cache = new CacheLayer();

	public boolean register(Customer customer,Account account) throws Exception {

		return cache.register(customer,account);
	}

	
	public boolean loginVerification(int customerId, int password) throws Exception {

		return cache.loginVerification(customerId, password);
	}

	public boolean addAccount(Account account) throws Exception {

		return cache.addAccount(account);
	}

	public boolean accountDetails(int accountId) throws Exception {

		return cache.accountDetails(accountId);
	}
	
	public boolean transfer(int fromAcc, int toAcc, double amount) throws Exception {
		
		return cache.transfer(fromAcc, toAcc, amount);
	}

	public boolean balance(int accountId) throws Exception {

		return cache.balance(accountId);
	}
	
	public boolean deposit(int accountId, double amount) throws Exception {
		
		return cache.deposit(accountId,amount);
	}
	
	public String withDraw(int accountId, double amount) throws Exception {
		
		return cache.withDraw(accountId, amount);
	}
	
	public boolean loan(Loan loan) throws Exception {
		
		return cache.loan(loan);
	}
	
	public List<Transaction> transMap(int accountId) throws Exception {
		
		return cache.transMap(accountId);
	}
	
	public Map<String, Loan> appliedLoan() throws Exception {
		
		return cache.appliedLoan();
	}
	
	public Map<Integer, Account> entireAccountDetails(int customerID) throws Exception {
		
		return cache.entireAccountDetails(customerID);
	}

}
