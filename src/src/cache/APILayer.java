package cache;

import java.util.HashMap;
import java.util.Map;

import accountdeclare.*;

public class APILayer {

	CacheLayer cache = new CacheLayer();

	public boolean customerRegister(Customer customer) {

		return cache.customerRegister(customer);
	}

	public boolean loginVerification(int customerId, int password) throws Exception {

		return cache.loginVerification(customerId, password);
	}

	  
	  public boolean addAccount(Account account) throws Exception {
	  
	  return cache.addAccount(account);
	  }
	  
	

		public boolean balance(Account account,int accountId) throws Exception {

			return cache.balance(account,accountId);
		}

	public boolean transfer(Map<Integer, Map<Integer, Account>> accountMap, int fromAcc, int toAcc, double amount)
			throws Exception {

		if (fromAcc <= 1000) {
			throw new Exception("Invalid From account");
		}
		if (toAcc <= 1000) {
			throw new Exception("Invalid To Account");
		}
		if (amount <= 0) {
			throw new Exception("Transaction canceled for following amount");
		}

		if (accountMap.containsKey(fromAcc)) {
			if (accountMap.containsKey(toAcc)) {
				if (amount > 0) {
					accountMap.get(fromAcc);
					// double toBal = accountMap.get(toAcc).getBalance()+amount;
					return true;
				} else {
					throw new Exception("Invalid amount");
				}
			} else {
				throw new Exception("To Account not available");
			}
		} else {
			throw new Exception("From Account not available");
		}
	}
}
