package input;

import java.util.*;

import manualexception.ManualException;



public class InputCenter {

	Scanner scanObj = new Scanner(System.in);
	
	public void nextLine() {
		scanObj.nextLine();
	}
	
	public String getString(String input) throws ManualException{
		System.out.println(input);
		
		
		try {
			String str = scanObj.nextLine();
			
			if(str!=null) {
			
				return str;
			}
		}
			catch(Exception e) {
				scanObj.nextLine();
				throw new ManualException("String can't be null");
			}
		return getString(input);
	}
	
	public int getInt(String input) throws ManualException{
		System.out.println(input);
		
		try {
			int intNum = scanObj.nextInt();
			scanObj.nextLine();
			return intNum;
		}
		
		catch(Exception e) {
			
			throw new ManualException("Integer only accepted");
			
		}
		
	}
	public long getLong(String input) throws ManualException{
		System.out.println(input);
		
		try {
			long longNum = scanObj.nextLong();
			scanObj.nextLine();
			return longNum;
		}
		catch(Exception e) {
			scanObj.nextLine();
			throw new ManualException("Long only accepted");
		}
	
	}
	
	public boolean getBoolean(String input) throws ManualException {
		System.out.println(input);
		
		try {
			boolean lean = scanObj.nextBoolean();
		
			return lean;
		}
		
		catch(Exception e) {
			throw new ManualException("Boolean only accepted");
		}
	}
	
	
}