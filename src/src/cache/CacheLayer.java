package cache;

import java.util.HashMap;
import java.util.Map;

import accountdeclare.*;

public class CacheLayer {
	private int customerId = 1000;

	private int pwd = 200;
	
	private  int accId = 2000;
	
	private int transId = 3000;

	public int customerId() {
		return ++customerId;
	}

	public int accId() {
		return ++accId;
	}
	
	public int autoPwd() {
		return ++pwd;
	}
	
	public int transId() {
		return ++transId;
	}

	Map<Integer, Customer> customerMap = new HashMap<>();

 Map<Integer, Map<Integer, Account>> accountMap = new HashMap<>();
 
 Map<Integer,Map<String,Loan>> loanMap = new HashMap<>();
	
	Map<Integer,Account> insideMap = new HashMap<>();

	Map<Integer, Integer> login = new HashMap<>();
	
	Map<String,Loan> loans = new HashMap<>();
	
	Map<Integer,Map<Integer, Transaction>> transMap = new HashMap<>();
	

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
			throw new Exception("Unavailable Account-ID");
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
			
			double from = insideMap.get(fromAcc).getBalance();
			
			
			
			if(!insideMap.containsKey(toAcc)) {
				
				Transaction transaction = new Transaction();
				
				transaction.setTransId(transId());
			
				transaction.setAccId(fromAcc);
				
				transaction.setToAcc(toAcc);
				
				transaction.setTransferredAmount(amount);
				
				transaction.setTimeAndDate(dateAndTime());

				transaction.setBalance(from);
				
				transaction.setType("Debit");
				
				transaction.setStatus(false);
				
				transaction.setResult("Invalid To Account");
				
				Map<Integer,Transaction> mapObj = transMap.get(fromAcc);
				
				if(mapObj == null) {
					
					mapObj = new HashMap<>();
					
					transMap.put(fromAcc, mapObj);
				}
				
				mapObj.put(transaction.getTransId(), transaction);
				
			throw new Exception("Invalid To Account");	
			}
			
             if(from-amount < 0.0) {
				
                Transaction transaction = new Transaction();
				
				transaction.setTransId(transId());
				
				transaction.setAccId(fromAcc);
				
				transaction.setToAcc(toAcc);
				
				transaction.setTransferredAmount(amount);
				
				transaction.setTimeAndDate(dateAndTime());

				transaction.setBalance(from);
				
				transaction.setType("Debit");
				
				transaction.setStatus(false);
				
				transaction.setResult("Insufficient Balance");
				
				Map<Integer,Transaction> mapObj = transMap.get(fromAcc);
				
				if(mapObj == null) {
					
					mapObj = new HashMap<>();
					
					transMap.put(fromAcc, mapObj);
					
				}
				
				mapObj.put(transaction.getTransId(), transaction);
				
				
				throw new Exception("Insufficient Balance to Transfer");
				
			}
			
			if (amount <= 0) {
				
				Transaction transaction = new Transaction();
				
				transaction.setTransId(transId());
				
				transaction.setAccId(fromAcc);
				
				transaction.setToAcc(toAcc);
				
				transaction.setTransferredAmount(amount);
				
				transaction.setTimeAndDate(dateAndTime());

				transaction.setBalance(from);
				
				transaction.setType("Debit");
				
				transaction.setStatus(false);
				
				transaction.setResult("Negative amount");
				
				Map<Integer,Transaction> mapObj = transMap.get(fromAcc);
				
				if(mapObj == null) {
					
					mapObj = new HashMap<>();
					
					transMap.put(fromAcc, mapObj);
				}
				
				mapObj.put(transaction.getTransId(), transaction);
				
				throw new Exception("Transaction canceled for negative amount");
			}
			
			double to = insideMap.get(toAcc).getBalance();

			if(fromAcc == toAcc) {
				
				Transaction transaction = new Transaction();
				
				transaction.setTransId(transId());
				
				transaction.setAccId(fromAcc);
				
				transaction.setToAcc(toAcc);
				
				transaction.setTransferredAmount(amount);
				
				transaction.setTimeAndDate(dateAndTime());

				transaction.setBalance(from);
				
				transaction.setType("Debit");
				
				transaction.setStatus(false);
				
				transaction.setResult("Same Account Transfer");
				
				Map<Integer,Transaction> mapObj = transMap.get(fromAcc);
				
				if(mapObj == null) {
					mapObj = new HashMap<>();
					transMap.put(fromAcc, mapObj);
				}
				mapObj.put(transaction.getTransId(), transaction);
				
				throw new Exception("Same Account Transfer Failed");
			}
			
						Transaction transaction = new Transaction();
						
						transaction.setTransId(transId());
						
						transaction.setAccId(fromAcc);
						
						transaction.setToAcc(toAcc);
						
						transaction.setType("Debit");
						
						transaction.setTransferredAmount(amount);
						
						transaction.setTimeAndDate(dateAndTime());
						
						System.out.println("Previous Balance: "+ from);
						
						insideMap.get(fromAcc).setBalance(from - amount);
						
						insideMap.get(toAcc).setBalance(to + amount);
						
						from = insideMap.get(fromAcc).getBalance();
						
						System.out.println("Current Balance: " + from);
						
						transaction.setBalance(from);
						
						transaction.setResult("Success");
					
						transaction.setStatus(true);
						
						Map<Integer,Transaction> mapObj = transMap.get(fromAcc);
						
						if(mapObj == null) {
							mapObj = new HashMap<>();
							transMap.put(fromAcc, mapObj);
						}
						mapObj.put(transaction.getTransId(), transaction);
						
						return true;
					
				} 
			
	

		
		public boolean deposit(int accountId , double amount) throws Exception {
			
			 double balance = insideMap.get(accountId).getBalance();
			
			if(amount <= 0) {
                
				Transaction transaction = new Transaction();
				
				transaction.setTransId(transId());
				
				transaction.setAccId(accountId);
				
				transaction.setToAcc(accountId);
				
				transaction.setTransferredAmount(amount);
				
				transaction.setTimeAndDate(dateAndTime());

				transaction.setBalance(balance);
				
				transaction.setType("Credit");
				
				transaction.setStatus(false);
				
				transaction.setResult("negative balance");
				
				Map<Integer,Transaction> mapObj = transMap.get(accountId);
				
				if(mapObj == null) {
					
					mapObj = new HashMap<>();
					
					transMap.put(accountId, mapObj);
				}
				mapObj.put(transaction.getTransId(), transaction);

				throw new Exception("Invalid Amount || Transaction Failed");
			}
			
			if(insideMap.containsKey(accountId)) {
				
				System.out.println("Prevoius Balance: "+ balance);
				
				double sum = amount + balance;
				
		        insideMap.get(accountId).setBalance(sum);
		        
		    	balance = insideMap.get(accountId).getBalance();
		    	
                Transaction transaction = new Transaction();
				
				transaction.setTransId(transId());
				
				transaction.setAccId(accountId);
				
				transaction.setToAcc(accountId);
				
				transaction.setTransferredAmount(amount);
				
				transaction.setTimeAndDate(dateAndTime());

				transaction.setBalance(balance);
				
				transaction.setType("Credit");
				
				transaction.setStatus(true);
				
				transaction.setResult("Credit Success");
				
				Map<Integer,Transaction> mapObj = transMap.get(accountId);
				
				if(mapObj == null) {
					
					mapObj = new HashMap<>();
					
					transMap.put(accountId, mapObj);
				}
				mapObj.put(transaction.getTransId(), transaction);
				
		    	
				System.out.println("Current Balance: "+ balance);
				
				return true;
			}
	
			throw new Exception("Invalid Acount ID || Transaction Failed");
		}
		
		public boolean withDraw(int accountId, double amount) throws Exception{
			
			double balance = insideMap.get(accountId).getBalance();
			
			
			if(amount<=0) {
				
				 Transaction transaction = new Transaction();
					
					transaction.setTransId(transId());
					
					transaction.setAccId(accountId);
					
					transaction.setToAcc(accountId);
					
					transaction.setTransferredAmount(amount);
					
					transaction.setTimeAndDate(dateAndTime());

					transaction.setBalance(balance);
					
					transaction.setType("Credit");
					
					transaction.setStatus(false);
					
					transaction.setResult("Negative amount");
					
					Map<Integer,Transaction> mapObj = transMap.get(accountId);
					
					if(mapObj == null) {
						
						mapObj = new HashMap<>();
						
						transMap.put(accountId, mapObj);
					}
					mapObj.put(transaction.getTransId(), transaction);
					
				throw new Exception("Invalid amount || Transaction Failed");
			}
			
			if(insideMap.containsKey(accountId)) {
					
				double diff = balance - amount;
				
				if(diff < 0.0) {
					
					balance = insideMap.get(accountId).getBalance();
					
					 Transaction transaction = new Transaction();
						
						transaction.setTransId(transId());
						
						transaction.setAccId(accountId);
						
						transaction.setToAcc(accountId);
						
						transaction.setTransferredAmount(amount);
						
						transaction.setTimeAndDate(dateAndTime());

						transaction.setBalance(balance);
						
						transaction.setType("Credit");
						
						transaction.setStatus(false);
						
						transaction.setResult("Insufficient Balance");
						
						Map<Integer,Transaction> mapObj = transMap.get(accountId);
						
						if(mapObj == null) {
							
							mapObj = new HashMap<>();
							
							transMap.put(accountId, mapObj);
						}
						mapObj.put(transaction.getTransId(), transaction);
						
					
					throw new Exception("Insufficient balance || Transaction Failed");
				}
				
				System.out.println("Previous Balance : "+ balance);
				
				insideMap.get(accountId).setBalance(diff);
				
				balance = insideMap.get(accountId).getBalance();
				
				 Transaction transaction = new Transaction();
					
					transaction.setTransId(transId());
					
					transaction.setAccId(accountId);
					
					transaction.setToAcc(accountId);
					
					transaction.setTransferredAmount(amount);
					
					transaction.setTimeAndDate(dateAndTime());

					transaction.setBalance(balance);
					
					transaction.setType("Debit");
					
					transaction.setStatus(true);
					
					transaction.setResult("Success");
					
					Map<Integer,Transaction> mapObj = transMap.get(accountId);
					
					if(mapObj == null) {
						
						mapObj = new HashMap<>();
						
						transMap.put(accountId, mapObj);
					}
					mapObj.put(transaction.getTransId(), transaction);
					

				System.out.println("Current Balance : "+balance);
				
				return true;
			}
			
			throw new Exception("Invalid Account Id || Transaction Failed");
		}
		
		public boolean transMap(int accountId) throws Exception {
			
			if(transMap.containsKey(accountId)) {
				
				if(transMap.get(accountId) == null) {
					
					System.out.println("No Transaction done");
					
					return true;
				} else {
					
					
					
					
						System.out.println(transMap.get(accountId));
					
				
				return true;
				
				}
			}
			
			throw new Exception("No Transaction done");
			
		}
		
		private Object dateAndTime() {
			
			long millis   = System.currentTimeMillis();
			
		    java.util.Date date = new java.util.Date(millis); 
		    
		     return date;
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
