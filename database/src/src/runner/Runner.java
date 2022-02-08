package runner;
import input.InputCenter;

import java.sql.SQLException;

import database.DB;
import manualexception.ManualException;

public class Runner {
public static void main(String[] args) throws ManualException, SQLException{
	InputCenter input = new InputCenter();
	DB query = new DB();
	int caseNum = input.getInt("Case No: ");
	
	switch(caseNum) {
	case 1:
		query.createTable();
		break;
	case 2:
		query.insertTable();
		break;
	case 3:
		query.updateRow();
		break;
	case 4:
		query.deleteRow();
		break;
	case 5:
		query.truncate();
		break;
	case 6:
		query.drop();
		break;
	case 7:
		query.select();
		break;
	case 8:
		query.insertTablePrepared();
		break;
	case 9:
		query.updateRowPrepared();
		break;
	case 10:
		query.deleteRowPrepared();
		break;
	case 11:
		query.truncatePrepared();
		break;
	case 12:
		query.dropPrepared();
		break;
	default:
		System.out.println("No case");
		break;
	}
}
}
