package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import input.InputCenter;
import manualexception.ManualException;

public class DB {
	InputCenter input = new InputCenter();
	
	String dburl = "jdbc:mysql://localhost:3306/ali";
	String name = "root";
	String pwd = "K@r0!KuD!";

public void createTable() throws ManualException {
	String create = input.getString("create query: ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
			Statement statement = connect.createStatement();){
		
		
		statement.execute(create);
			System.out.println("Table Created");
		
	}catch(Exception e) {
		e.printStackTrace();
		throw new ManualException("Create Query Failed ");
		
	}
}

public void insertTable() throws ManualException, SQLException {
	try(Connection connect = DriverManager.getConnection(dburl,name,pwd); 
			Statement statement = connect.createStatement(); ) {
		
		
		
		int count = input.getInt("how many insertion: ");
		
		for(int i = 1; i <= count; i++) {
			String insertQuery = input.getString(i + " th insert query: ");
			statement.executeUpdate(insertQuery);
		}
		
		System.out.println(count + " Row created");
		
	} catch(Exception e) {
		e.printStackTrace();
		throw new ManualException("Insert Query Failed ");
	}
}

public void updateRow() throws ManualException, SQLException{
	String update = input.getString("Update Query: ");
	try(Connection connect = DriverManager.getConnection(dburl,name,pwd);
			Statement statement = connect.createStatement();){
	
		
		statement.execute(update);
			System.out.println("1 Row Updated");
			}catch(Exception e) {
		throw new ManualException("Update Query Failed ");
	}
}

public void deleteRow() throws ManualException , SQLException {
	String delete = input.getString("Delete Query : ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
Statement statement = connect.createStatement();) {
	
	statement.execute(delete);
		System.out.println("1 Row Deleted");
	}catch(Exception e) {
		throw new ManualException("Delete Query Failed");
	}
}

public void truncate() throws ManualException , SQLException {
	String truncate = input.getString("Truncate Query: ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
			Statement statement = connect.createStatement(); ){
				
		
		statement.execute(truncate);
			System.out.println("Table Truncated");
		
		}catch(Exception e) {
				e.printStackTrace();
				throw new ManualException("Truncate Query Failed");
			}
}

public void drop() throws ManualException , SQLException {
	String drop = input.getString("Drop Query: ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
			Statement statement = connect.createStatement();){
	
		statement.execute(drop);
			System.out.println("Table Dropped");
		
	}catch(Exception e) {
		e.printStackTrace();
		throw new ManualException("Drop Query Failed "+e);
	}
}


public void select() throws ManualException, SQLException {
	String select = input.getString("Select query: ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
			Statement statement = connect.createStatement();){
		
		ResultSet rs = statement.executeQuery(select);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		} catch(Exception e) {
		e.printStackTrace();
		throw new ManualException("Select query failed");
	}
	
}



public void insertTablePrepared() throws ManualException, SQLException {
	String insertQuery = input.getString("prepared insert query : ");
	try(Connection connect = DriverManager.getConnection(dburl,name,pwd); 
			PreparedStatement statement = connect.prepareStatement(insertQuery); ) {
		int count = input.getInt("how many insertion: ");
		
		for(int i = 1; i <= count; i++) {
			int id = input.getInt(i+ " id: ");
			statement.setInt(1,id);
			String name = input.getString(i+ " name: ");
			statement.setString(2,name);
			statement.executeUpdate();
		}
		
		System.out.println(count + " Row created");
		
	} catch(Exception e) {
		e.printStackTrace();
		throw new ManualException("Insert Query Failed " + e);
	}
}

public void updateRowPrepared() throws ManualException, SQLException{
	String update = input.getString("Prepared Update Query: ");
	try(Connection connect = DriverManager.getConnection(dburl,name,pwd);
			PreparedStatement statement = connect.prepareStatement(update);){
		    int id = input.getInt("id: ");
		    statement.setInt(1, id);
		    String name = input.getString("name: ");
		    statement.setString(2, name);
		    statement.executeUpdate();
		    
			System.out.println("1 Row Updated");
			}catch(Exception e) {
		throw new ManualException("Update Query Failed " + e);
	}
}

public void deleteRowPrepared() throws ManualException , SQLException {
	String delete = input.getString("Prepared Delete Query : ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
     PreparedStatement statement= connect.prepareStatement(delete);) {
		String decision = input.getString("id or name: ");
		
		if(decision.equals("id")) {
		int id = input.getInt("id: ");
	    statement.setInt(1, id);
	    statement.executeUpdate();
		}
		else {
	    String name = input.getString("name: ");
	    statement.setString(1, name);
	    statement.executeUpdate();
		}
		System.out.println("1 Row Deleted");
	}catch(Exception e) {
		throw new ManualException("Delete Query Failed");
	}
}

public void truncatePrepared() throws ManualException , SQLException {
	String truncate = input.getString("Truncate Query: ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
			PreparedStatement statement = connect.prepareStatement(truncate); ){
				
		
		statement.execute();
			System.out.println("Table Truncated");
		
		}catch(Exception e) {
				e.printStackTrace();
				throw new ManualException("Truncate Query Failed");
			}
}

public void dropPrepared() throws ManualException , SQLException {
	String drop = input.getString("Prepared Drop Query: ");
	try(Connection connect = DriverManager.getConnection(dburl, name, pwd);
		PreparedStatement statement = connect.prepareStatement(drop);){
		statement.execute();
			System.out.println("Table Dropped");
		
	}catch(Exception e) {
		e.printStackTrace();
		throw new ManualException("Drop Query Failed "+e);
	}
}

}
