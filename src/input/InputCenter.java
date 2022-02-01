package input;

import java.util.*;

public class InputCenter {

	Scanner sc = new Scanner(System.in);
	
	public int getInt(String statement) {
		System.out.println(statement);
		try {
		int integer = sc.nextInt();
	
		return integer;
		}
		catch(Exception e) {
			System.out.println("Only Int");
		}
		return getInt(statement);
	}
	
	public String getString(String statement) {
		System.out.println(statement);
		String string = sc.next();
		return string;
	}
	
	public boolean getBoolean(String statement) {
		System.out.println(statement);
		try {
			boolean bool = sc.nextBoolean();
			
			return bool;
		} catch(Exception e) {
			System.out.println("only boolean");
		}
		return getBoolean(statement);
	}
	
	public char getChar(String statement) {
		System.out.println(statement);
		try {
			char ch = sc.next().charAt(0);
			
			return ch;
		}
		catch(Exception e) {
			System.out.println("Only char");
		}
		return getChar(statement);
	}
	
	public long getLong(String statement) {
		System.out.println(statement);
	try {
		long lo = sc.nextLong();
		
		return lo;
	} catch(Exception e) {
		System.out.println("only long");
	}
	return getLong(statement);
	}
	
}
