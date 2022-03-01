package bankrunner;

import customerinfo.CustomerInfo;
import myscanner.MyScanner;
import proexception.ProException;
import accountinfo.AccountInfo;
import bankinglogic.BankingLogic;



public class BankRunner {

	MyScanner input=new MyScanner();
	
	BankingLogic api=null;
	
	public BankRunner()
	{
		try
		{
			api=new BankingLogic();
			
		}
		catch(ProException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	  	  
	  // add customer info
	  
		private void putCustomerInfo() {

			int numberCustomer = input.getInputNumber("Enter the  number of customer you want to add");

			for (int i = 0; i < numberCustomer; i++) 
			{
				CustomerInfo customerData = new CustomerInfo();
				try {
					String name = input.getInput("Enter the customer Name");
					
					String address = input.getInput("Enter the customer Address");
					
					String mobile = input.getInput("Enter the customer Mobile Number");

					customerData.setName(name);
					
					customerData.setAddress(address);
					
					customerData.setMobile(mobile);

					api.addCustomer(customerData);
					
				} catch (ProException e)
				{
					System.out.println(e);
				}

			}

		}
	  
		private void putAccountInfo() {

			int numberaccount = input.getInputNumber("Enter the  number of account you want to add");

			for (int i = 0; i <numberaccount; i++) 
			{
				AccountInfo accountData = new AccountInfo();
				try {
					int id = input.getInputNumber("Enter the customer id");
					
					String branch = input.getInput("Enter the customer branch");
					
			     	int balance = input.getInputNumber("Enter the customer balance");

					
					accountData.setCustomerId(id);
					accountData.setBranch(branch);
					accountData.setBalance(balance);
					api.addAccount(accountData);
					
				} catch (ProException e)
				{
					System.out.println(e);
				}

			}

		}
	  
	  
	  // get customer info by using customer id
	  
		private void getCustomerById() 
		{
			int id = input.getInputNumber("Enter the customer id");
			
			System.out.println(api.getCustomer(id));

			
		}

	 
	  
	  // get all account details of customer by using customer id
	  
	  
		private void getAllAccount() 
		{
			    int id = input.getInputNumber("Enter the customer id");
			
				System.out.println(api.getAccount(id));
			
		}
	  
	 
	  // change status of customer
	  
		private void changeStatusCustomerInfo()
		{
			
			int customerId = input.getInputNumber("Enter the customer id");

			System.out.println("Enter 0 for deActivation");

			System.out.println("Enter 1 for activation");

			int status = input.getInputNumber("enter 0 or 1");

			try {
				
				api.changeCustomerStatus(customerId, status);

				System.out.println("status changed successfully");
				
			} catch (ProException e) 
			{
				System.out.println(e);
				e.printStackTrace();
			}

		}
	  
	  // change status of account
	  
		private void changeStatusAccountInfo() 
		{
			int customerId = input.getInputNumber("Enter the customer id");

			int accountId = input.getInputNumber("Enter the account id");

			System.out.println("Enter 0 for deActivation");

			System.out.println("Enter 1 for activation");

			int status = input.getInputNumber("enter 0 or 1");

			try {
				api.changeAccountStatus(customerId, accountId, status);

				System.out.println("status changed successfully");
				
			} catch (ProException e) 
			{
				System.out.println(e);
			}
		}
	  
		public void addDeposit() 
		{
			int customerId = input.getInputNumber("Enter the customer id");

			int accountId = input.getInputNumber("Enter the account id");

			int deposit = input.getInputNumber("Enter the deposit amount");

			try {
				
				api.deposit(customerId, accountId, deposit);
			} 
			catch (ProException e) 
			{
				System.out.println(e);
			}

		}
	  
	 
	  
	  
		public void withDrawAmt()
		{
			int customerId = input.getInputNumber("Enter the customer id");

			int accountId = input.getInputNumber("Enter the account id");

			int withdraw = input.getInputNumber("Enter the withdraw amount");

			try 
			{
				api.withdrawal(customerId, accountId, withdraw);
				
			} catch (ProException e) 
			{
				System.out.println(e);
			}
		}
		
		
	
		 
	  
	  //main method
	  
	  public static void main(String[] args) { MyScanner input=new MyScanner();
	  
	  BankRunner run = new BankRunner();
	  
	  int number=input.getInputNumber("Enter the case number");
	  
	  switch(number) {
	  
	  case 1:run.putCustomerInfo(); break;
	  
	  case 2:run.putAccountInfo();break;
	  
	  case 3:run.getCustomerById(); break;
	  
	  case 4:run.getAllAccount(); break;
	  
	  case 5:run.changeStatusCustomerInfo(); break;
	  
	  case 6:run.changeStatusAccountInfo(); break;
	  
	  case 7:run.addDeposit(); break;
	  
	  case 8:run.withDrawAmt(); break;
	  
	  
	  
	  } }
	 
	}


