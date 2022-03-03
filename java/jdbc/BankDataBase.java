package jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import accountdeclare.Account;
import accountdeclare.Customer;
import accountdeclare.User;
import manualexception.ManualException;
import utility.MapUtility;

public class BankDataBase
{	
	MapUtility utility=new MapUtility();
	
	private int customerID;
	private int accountID;
	
	public void createTable(String createQuery) throws ManualException
	{	
		Connection connection=Connectivity.CONNECT.getConnect();
		
		try(Statement statement=connection.createStatement();)
		{
			statement.execute(createQuery);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			
			throw new ManualException(e);
		}
	}
	
	public int insertRecord(String insertQuery) throws ManualException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		
		try(Statement statement=connection.createStatement();)
		{
			statement.executeUpdate(insertQuery,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet result=statement.getGeneratedKeys();
			
			result.next();
			
			return result.getInt(1);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ManualException(e);
		}
	}
	
	public int updateRecord(String updateQuery) throws ManualException
	{
		Connection connection=Connectivity.CONNECT.getConnect();
		
		try(Statement statement=connection.createStatement();)
		{
			int number=statement.executeUpdate(updateQuery);
			return number;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new ManualException(e);
		}
	}

	public Customer selectCustomerRecord(String selectQuery)throws ManualException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		
		try(Statement statement = connection.createStatement())
		{
			 ResultSet resultSet=statement.executeQuery(selectQuery);
			 
			 while(resultSet.next())
			 {
				 Customer customerInfo=new Customer();
				 
				 customerInfo.setCustomerId(resultSet.getInt("CustomerID"));
				 
				 customerInfo.setCustomerName(resultSet.getString("Name"));
				 
				 customerInfo.setAddress(resultSet.getString("Address"));
				 
				 customerInfo.setMobile(resultSet.getLong("Mobile"));
				 
				 customerInfo.setStatus(resultSet.getBoolean("Status"));
				 
				 return customerInfo;
			 }
			 return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new ManualException(e);
		}
	}
	
	public Account selectAccountRecord(String selectQuery)throws ManualException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		
		try(Statement statement = connection.createStatement())
		{
			 ResultSet resultSet=statement.executeQuery(selectQuery);
			 
			 while(resultSet.next())
			 {
				 Account accountInfo=new Account();
				 
				 accountInfo.setAccountID(resultSet.getInt("AccountID"));
				 
				 accountInfo.setCustomerID(resultSet.getInt("CustomerID"));
				 
				 accountInfo.setBranchName(resultSet.getString("Branch")); 
				 
				 accountInfo.setBankBalance(resultSet.getDouble("Balance"));
				 
				 accountInfo.setStatus(resultSet.getBoolean("Status"));
				 
				 return accountInfo;
			 }
			 return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new ManualException(e);
		}
	}
	
	public Map<Integer,Customer> readCustomer() throws ManualException
	{
		Map<Integer,Customer> customerData=new HashMap<>();
		
		Connection connection = Connectivity.CONNECT.getConnect();
		
		try(Statement statement = connection.createStatement())
		{
			 String selectQuery="select * from CUSTOMER;";
			 
			 ResultSet result=statement.executeQuery(selectQuery);
			
			 while(result.next())
			 {
				 Customer customerInfo=new Customer();
				 
				 customerInfo.setCustomerId(result.getInt("CustomerID"));
				 
				 customerInfo.setCustomerName(result.getString("Name"));
				 
				 customerInfo.setAddress(result.getString("Address"));
				 
				 customerInfo.setMobile(result.getLong("Mobile"));
				 
				 customerID=result.getInt("CustomerID");
				 
				 utility.putCustomerDetails(customerData,customerID,customerInfo);
			 }
			 
			 return customerData;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			throw new ManualException(e);
		}
	}
	
	public Map<Integer,Map<Integer,Account>> readAccount() throws ManualException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		
		Map<Integer,Map<Integer,Account>> accountData=new  HashMap<>();
		
		try(Statement statement = connection.createStatement())
		{
			String sql="select * from ACCOUNT;";
			
			try(ResultSet result=statement.executeQuery(sql);)
			{
				while(result.next())
				{
					 Account accountInfo=new Account();
					 
					 accountInfo.setCustomerID(result.getInt("CustomerID"));
					 
					 accountInfo.setBranchName(result.getString("Branch"));
					 
					 accountInfo.setBankBalance(result.getDouble("Balance"));
					 
					 accountInfo.setStatus(result.getBoolean("Status"));
					 
					 accountInfo.setAccountID(result.getInt("AccountID"));
					 
					 accountID=result.getInt("AccountID");
					 
					 utility.putAccountDetails(accountData, accountID, accountInfo);
				 }
			}
			 return accountData;
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			throw new ManualException(e);
		}
	}

	public Map<String, Integer> validatePassword(String query,String password) throws ManualException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		
		try(Statement statement = connection.createStatement())
		{
			 Map <String, Integer> map=new HashMap<String, Integer>();
			 
			 ResultSet result=statement.executeQuery(query);
			 
			 while(result.next())
			 {
				 if(password.equals(result.getString(2)))
				 {
					 map.put("CustomerId",result.getInt(4));
					 
					 map.put("RoleId",result.getInt(3));
				 }
			 }
			 return map;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new ManualException(e);
		}
	}
	
	
	public User selectUserDetails(String query)throws ManualException
	{
		Connection connection = Connectivity.CONNECT.getConnect();
		
		try(Statement statement = connection.createStatement())
		{
			 ResultSet result=statement.executeQuery(query);
			 
			 User userInfo=new User();
			 
			 while(result.next())
			 {
				 userInfo.setCustomerID(result.getInt(1));
				 
				 userInfo.setPassword(result.getString(2));
				 
				 userInfo.setRoleID(result.getInt(3));
				 
				 userInfo.setCustomerID(result.getInt(4));
			 }
			 return userInfo;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			throw new ManualException(e);
		}
	}
	
	public int getAccountId()
	{
		return accountID;
	}
	
}
