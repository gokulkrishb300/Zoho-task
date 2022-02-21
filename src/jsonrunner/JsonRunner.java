
package jsonrunner;
import accountdeclare.*;
import input.InputCenter;
import jsonapi.JsonApi;
import manualexception.ManualException;

public class JsonRunner
{
	
	JsonApi logic=new JsonApi();
	InputCenter input=new InputCenter();
	
	
	private void putInfo(int size) throws ManualException
	{
		for(int i=0;i<size;i++)
		{
			CustomerDetails customerObj=new CustomerDetails();
						
			customerObj.setName(input.getString("Enter a name for Customer"));
		
			customerObj.setGender(input.getString("Enter gender"));
			
			customerObj.setAge(input.getInt("enter age"));
			
			customerObj.setMobile(input.getLong("Enter a Mobile Number"));
			
			try
			{
				logic.putCustomer(customerObj);
			}
			catch(ManualException e)
			{
				e.getMessage();
				e.printStackTrace();
			}
		}
	}
	
	private void putAccountInfo(int size) throws ManualException
	{
		for(int i=0;i<size;i++)
		{
			AccountDetails accountObj=new AccountDetails();
			
			accountObj.setCustId(input.getInt("CustomerId"));

			accountObj.setAccNum(input.getLong("Account num"));
			
			accountObj.setBranch(input.getString("Enter a name for Branchname"));
			
			accountObj.setAccType(input.getString("Account type"));
			
			
			try
			{
				logic.putAccount(accountObj);
			}
			catch(ManualException e)
			{
				e.getMessage();
				e.printStackTrace();
			}
		}
	}
	private void getAccount() throws ManualException
	{
	
		int customerId=input.getInt("Enter the customer customerId :");
	
		int acId=input.getInt("Enter the Account customerId :");
		try {
			System.out.println(logic.getAccount(customerId,acId));
		} catch (ManualException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	private void withdraw() throws ManualException
	{
		
		int customerId=input.getInt("Enter customer Id");
		
		int accountId=input.getInt("Enter Account no");
		
		long number=input.getLong("Enter a amount for withdrawl");
		try {
			System.out.println(logic.withdraw(customerId,accountId,number));
		} catch (ManualException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void deposit() throws ManualException
	{
		
		int customerId=input.getInt("Enter customer Id");
	
		int accountId=input.getInt("Enter Account no");
	
		long number=input.getLong("Enter a amount for deposit");
		try {
			System.out.println(logic.deposit(customerId,accountId,number));
		} catch (ManualException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void balance() throws ManualException
	{
		
		int customerId=input.getInt("Enter customer Id");
		
		int accountId=input.getInt("Enter Account no");
		try {
			System.out.println(logic.getBalance(customerId,accountId));
		} catch (ManualException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	
	private void read()
	{
		try {
			System.out.println(logic.readCustomer());
			System.out.println(logic.readAccount());
			System.out.println(logic.readKey());
		} catch (ManualException e) {
			e.printStackTrace();
		}
	}
	private void load() 
	{
		try {
			logic.fetchDetails();
		} catch (ManualException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void status() throws ManualException {
		int customerId = input.getInt("Enter CustomerID: ");
		int accountId = input.getInt("Enter accountID: ");
		boolean flag = input.getBoolean("Enter true for active or viceversa");
		logic.accountStatus(customerId, accountId, flag);
	}

	private void entireCustomerAcc() throws ManualException {
		int customerId = input.getInt("Enter customerID: ");
		System.out.println(logic.entireCustomerAccounts(customerId));
	}
	
	private void customerDetails() throws ManualException {
		
		int customerId = input.getInt("Enter CustomerID: ");
		
		System.out.println(logic.getCustomerDetails(customerId));
	}
	public static void main(String[] args)throws ManualException{
		
		JsonRunner runner = new JsonRunner();
		
		InputCenter input=new InputCenter();
		
		boolean flag=true;

		
		while(flag)
		{
			int choice=input.getInt("Enter your choice");
			switch(choice)
			{
			
			
				case 0:
					flag=false;
					System.out.println("Exit");
					break;
					
				
					
				case 1:
					int size=input.getInt("No.of Customer Details");
					runner.putInfo(size);
					break;
					
				case 2:
					
					int num=input.getInt("No.of Account Details");
					runner.putAccountInfo(num);
					break;	
							
				case 3:
					runner.getAccount();
					break;
					
				case 4:
					runner.balance();
					break;
					
				case 5:
					runner.status();
					break;
					
				case 6:
					runner.deposit();
					break;
					
				case 7:
					runner.withdraw();
					break;
					
				case 8:
					runner.read();//read
					break;
				
				case 9:
					runner.load();//load
					break;
		
				case 10:
					runner.entireCustomerAcc();
					break;
					
				case 11:
					runner.customerDetails();
					break;
					
				default:
					System.out.println("Unavailable");
					break;
			}
			
		}
	}
}