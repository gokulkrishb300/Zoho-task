package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import manualexception.ManualException;

enum Connectivity 
{
	CONNECT;
	
	private Connection connect=null;
	
	public Connection getConnect() throws ManualException
	{
		
		if(connect==null)
		{
		String url="jdbc:mysql://localhost:3306/BANK";
		
		String uName="root";
		
		String uPassword="K@r0!KuD!";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect=DriverManager.getConnection(url,uName,uPassword);
			
			return connect;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ManualException(e);
		}
		}
			return connect;
		
	}
	public void closeConnect()
	{
		try
		{
			if(connect!=null)
			{
				connect.close();
			}
		}
		catch(SQLException e){}
	}
}