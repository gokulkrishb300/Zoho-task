package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accountdeclare.*;

public class CacheLayer {
	private int userId = 1000;

	private int pwd = 100;

	public int autoUserId() {
		return ++userId;
	}

	public int autoPwd() {
		return ++pwd;
	}

	private int accId = 2000;

	public int accId() {
		return ++accId;
	}

	List<Object> registerList = new ArrayList<>();

	Map<Integer, Customer> customerMap = new HashMap<>();

	Map<Integer, Map<Integer, Account>> accountMap = new HashMap<>();
	
	Map<Integer,Account> insideMap = new HashMap<>();

	Map<Integer, Integer> login = new HashMap<>();

	public boolean customerRegister(Customer customer) {

		customer.setCustId(autoUserId());

		int customerId = customer.getCustId();

		login.put(customerId, autoPwd());

		customerMap.put(customerId, customer);

		System.out.println("Here's your auto generated user ID =  " + '\u0022' + customerId + '\u0022'
				+ " and Password = " + '\u0022' + login.get(customer.getCustId()) + '\u0022');

		return true;
	}



	public boolean loginVerification(int customerId, int password) throws Exception {

		if (login.containsKey(customerId)) {

			if (login.get(customerId) == password) {
				
				System.out.println("Login verified");
			} else {
				throw new Exception("Enter correct password");
			}
		} else {
			throw new Exception("UserId not exist");
		}
		return true;
	}

	  
		public boolean addAccount(Account account) throws Exception {

			if (account == null) {
				throw new Exception("Account Details is null");
			}

			if (accountMap == null) {
				throw new Exception("Account Map is null");
			}

			int customerId = account.getCustomerId();

			Map<Integer, Account> mapObj = accountMap.get(customerId);
			if (mapObj == null) {
				mapObj = new HashMap<>();
				accountMap.put(customerId, mapObj);

			}
			account.setAccountId(accId());
			
			mapObj.put(account.getAccountId(), account);
			
			insideMap.put(account.getAccountId(), account);
			
			return true;
		}
		
		public boolean accountDetails(Account account , int accId) throws Exception{
			
			if(accId <= 2000) {
				throw new Exception("invalid account ID");
			}
			
			if(insideMap.containsKey(accId)) {
				System.out.println(insideMap.get(accId));
				return true;
			}
			return false;
		}
	  
		public boolean balance(Account account,int accId) throws Exception {

			if (accId <= 2000) {
				throw new Exception("invalid account ID");
			}
			
			if(insideMap.containsKey(accId)) {
				System.out.println("Balance : " +insideMap.get(accId).getBalance());
			}
			return false;
		}
		


}
