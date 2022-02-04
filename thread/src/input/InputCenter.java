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
			sc.nextLine();
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
			sc.nextLine();
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
			sc.nextLine();
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
		sc.nextLine();
	}
	return getLong(statement);
	}
	
}
