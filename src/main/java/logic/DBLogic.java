package logic;

import java.util.Map;

import accountdeclare.Account;
import accountdeclare.Customer;
import accountdeclare.User;
import jdbc.BankDataBase;
import manualexception.ManualException;
import persistencelayer.PersistenceLayer;

public class DBLogic implements PersistenceLayer
{
	BankDataBase dataBase=new BankDataBase();
	
	public boolean create()throws ManualException
	{
		dataBase.createTable("create table if not exists CUSTOMER (CustomerID int not null auto_increment,Name varchar(30),Address varchar(100),Mobile int,Status boolean default true,primary key(customerID));"); 
		
		dataBase.createTable("create table if not exists ACCOUNT (AccountID int not null auto_increment,CustomerID int not null,Branch varchar(30),Balance int,Status boolean default true,primary key(accountID),foreign key (CustomerID) references CUSTOMER(CustomerID));");
		
		return true;
	}
	
	public Customer putCustomerDetails(Customer customer)throws ManualException
	{
		String customerName=customer.getCustomerName();
		
		String address=customer.getAddress();
		
		long mobile=customer.getMobile();
		
		int customerID=dataBase.insertRecord("insert into CUSTOMER(Name,Address,Mobile) values('"+ customerName +"','"+ address +"',"+ mobile+");");
		
		customer.setCustomerId(customerID);
		
		return customer;
	}
	public Account putAccountDetails(Account account)throws ManualException
	{
		int customerID=account.getCustomerID();
		
		String branchName=account.getBranchName();
		
		double bankBalance=account.getBankBalance();
		
		dataBase.insertRecord("insert into ACCOUNT(CustomerID,Branch,Balance) values("+ customerID +",'"+ branchName +"',"+ bankBalance +");");
		
		return account;
	}
	
	public Customer getCustomerDetails(int customerID)throws ManualException
	{
		return dataBase.selectCustomerRecord("select * from CUSTOMER where CustomerID="+customerID+";");
	}
	public Account getAccountDetails(int customerID,int accountId)throws ManualException
	{
		return dataBase.selectAccountRecord("select * from  ACCOUNT where AccountID="+ accountId +" and CustomerID="+ customerID +";");
	}

	
	public boolean setCustomerState(int customerID,boolean flag) throws ManualException
	{
		dataBase.updateRecord("update CUSTOMER set Status="+flag+" where CustomerID="+customerID+";");
		return true;
	}
	public boolean setAccountState(int customerID,int accountId,boolean flag) throws ManualException
	{
		dataBase.updateRecord("update ACCOUNT set Status="+ flag +" where AccountID="+ accountId +" and CustomerID="+ customerID +";");
		
		return true;
	}
	
	public boolean deposit(int customerID,int accountId,double amount)throws ManualException
	{
		
		dataBase.updateRecord("update ACCOUNT set Balance=Balance+"+amount+" where AccountId="+ accountId +" and CustomerID="+ customerID +";");
		
		return true;
	}
	public boolean withdraw(int customerID,int accountId,double amount)throws ManualException
	{
		
		dataBase.updateRecord("update ACCOUNT set Balance=Balance-"+amount +" where AccountID="+ accountId +" and CustomerID="+ customerID +";");
		
		return true;
	}
	
	public Map<String,Integer> validatePassword(int userId,String password)throws ManualException
	{
		return dataBase.validatePassword("select * from  USER where USERID="+ userId +";",password);
	}
	
	public Map<Integer,Customer> readCustomerDetails()throws ManualException
	{
		return dataBase.readCustomer();
	}
	public Map<Integer,Map<Integer,Account>> readAccountDetails()throws ManualException
	{
		return dataBase.readAccount();
	}
	
	public User getUserDetails(int userId)throws ManualException
	{
		String query="select * from  USER where USERID="+ userId +";";
		
		return dataBase.selectUserDetails(query);
	}
	
	public int getCustomerId(int accountId) throws ManualException {
		
		String query = "select * from ACCOUNT where AccountID="+accountId+";";
		
		return dataBase.getCustomerId(query);
	}

	
	public int getAccountId()
	{
		return dataBase.getAccountId();
	}
	
}
