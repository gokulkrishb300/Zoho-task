package cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accountdeclare.*;

public class CacheLayer {
	private int customerId = 1000;

	private int pwd = 200;

	public int customerId() {
		return ++customerId;
	}

	private  int accId = 2000;

	public int accId() {
		return ++accId;
	}
	
	public int autoPwd() {
		return ++pwd;
	}
	

	List<Object> registerList = new ArrayList<>();

	Map<Integer, Customer> customerMap = new HashMap<>();

 Map<Integer, Map<Integer, Account>> accountMap = new HashMap<>();
 
 Map<Integer,Map<String,Loan>> loanMap = new HashMap<>();
	
	Map<Integer,Account> insideMap = new HashMap<>();

	Map<Integer, Integer> login = new HashMap<>();
	
	Map<String,Loan> loans = new HashMap<>();
	

	public boolean register(Customer customer,Account account) throws Exception {
		
		if(customer == null) {
			
			throw new Exception("Customer Details is null");
		}
		
		if(account == null) {
			throw new Exception("Account Details is null");
		}
		
		customer.setCustId(customerId());
		
		int customerId = customer.getCustId();
		
		customerMap.put(customerId, customer);
		
		account.setCustomerId(customerId);

		account.setAccountId(accId());
		
		int accountId = account.getAccountId();
		
		login.put(accountId, autoPwd());
		
		insideMap.put(accountId, account);
		
		accountMap.put(customerId, insideMap);
		

		System.out.println("Here's your account ID =  " + '\u0022' + accountId + '\u0022'
				+ " and Password = " + '\u0022' + login.get(accountId) + '\u0022');

		return true;
		
		
	}



	public boolean loginVerification(int accountId, int password) throws Exception {

		if (login.containsKey(accountId)) {

			if (login.get(accountId) == password) {

				System.out.println("Logged in successfully");
			} else {
				throw new Exception("Enter correct password");
			}
		} else {
			throw new Exception("AccountId not exist");
		}
		return true;
	}
	  
	
		public boolean addAccount(Account account) throws Exception {

			if (account == null) {
				throw new Exception("Account Details is null");
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
		
		public boolean accountDetails(int accId) throws Exception{
			
			if(accId <= 2000) {
				throw new Exception("invalid account ID");
			}
			
			if(insideMap.containsKey(accId)) {
				System.out.println(insideMap.get(accId));
				return true;
			}
			return false;
		}
	  
		public boolean balance(int accId) throws Exception {

	
			if(insideMap.containsKey(accId)) {
				
				System.out.println("Balance : " +insideMap.get(accId).getBalance());
				
				return true;
			} 
			
			throw new Exception("Invalid account-ID");
		}
		

		public boolean transfer(int fromAcc, int toAcc, double amount)
				throws Exception {

			if (amount <= 0) {
				throw new Exception("Transaction canceled for following amount");
			}
			
			if(fromAcc == toAcc) {
				throw new Exception("Same Account Transfer Failed");
			}

			if (insideMap.containsKey(fromAcc)) {
				
				if (insideMap.containsKey(toAcc)) {
					
					if (amount > 0) {
						
						double from = insideMap.get(fromAcc).getBalance();
						
						double to = insideMap.get(toAcc).getBalance();
						
						System.out.println("Previous Balance: "+ from);
						
						insideMap.get(fromAcc).setBalance(from - amount);
						
						insideMap.get(toAcc).setBalance(to + amount);
						
						from = insideMap.get(fromAcc).getBalance();
						
						System.out.println("Current Balance: " + from);
						
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

		
		public boolean deposit(int accountId , double amount) throws Exception {
			
			if(amount <= 0) {
				throw new Exception("Invalid Amount || Transaction Failed");
			}
			
			if(insideMap.containsKey(accountId)) {
				
			   double balance = insideMap.get(accountId).getBalance();
				
				System.out.println("Prevoius Balance: "+ balance);
				
				double sum = amount + balance;
				
		        insideMap.get(accountId).setBalance(sum);
		        
		    	balance = insideMap.get(accountId).getBalance();
		    	
		    	
				System.out.println("Current Balance: "+ balance);
				
				return true;
			}
	
			throw new Exception("Invalid Acount ID || Transaction Failed");
		}
		
		public boolean withDraw(int accountId, double amount) throws Exception{
			
			if(amount<=0) {
				throw new Exception("Invalid amount || Transaction Failed");
			}
			
			if(insideMap.containsKey(accountId)) {
				
				double balance = insideMap.get(accountId).getBalance();
				
				
				
				double diff = balance - amount;
				
				if(diff < 0.0) {
					
					balance = insideMap.get(accountId).getBalance();
					
					throw new Exception("Insufficient balance");
				}
				
				System.out.println("Previous Balance : "+ balance);
				
				insideMap.get(accountId).setBalance(diff);
				
				balance = insideMap.get(accountId).getBalance();

				System.out.println("Current Balance : "+balance);
				
				return true;
			}
			
			throw new Exception("Invalid Account Id || Transaction Failed");
		}
		
		public boolean loan(Loan loan) throws Exception {
			
			if(loan == null) {
				
				throw new Exception("Loan details is null");
			}
			
			System.out.println("--- Application Processing ---");
			
			int accountId = loan.getAccountId();
			
			Map<String,Loan> mapObj  = loanMap.get(accountId);
			
			if(mapObj == null) {
				
				mapObj = new HashMap<>();
				
				loanMap.put(accountId, mapObj);
			}
			
			mapObj.put(loan.getLoanType(),loan);
			
			loans.put(loan.getLoanType(), loan);
			
			System.out.println("--- Submission Success ---");
			System.out.println("--- Wait for approval ---");
			
			return true;
		}
		
		public boolean appliedLoan() throws Exception {
			
			if(loans == null || loans.isEmpty()) {
				throw new Exception("No loans applied");
			} 
			
			System.out.println(loans);
			
			return true;
		}
		
		public boolean entireAccountDetails(int customerId) throws Exception{
			
			if(accountMap.containsKey(customerId)) {
				
				System.out.println(accountMap.get(customerId));
				
				return true;
			}
			throw new Exception("Invalid CustomerID");
		}

}
