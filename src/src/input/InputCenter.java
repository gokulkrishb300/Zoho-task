package input;
import java.util.*;

public class InputCenter {
Scanner sc = new Scanner(System.in);
	public int number(String input) {
		System.out.println(input);
		try {
			int num = sc.nextInt();
			sc.nextLine();
			return num;
		} catch(Exception e) {
			sc.nextLine();
			System.out.println("Integer input only");
		}
		return number(input);
	}
	
	public String string(String input) {
		System.out.println(input);
		try {
			String value = sc.nextLine();
			if(value!=null) {
			return value;
			}
		}
		catch(Exception e) {
			System.out.println("String input only");
		}
		return string(input);
	}
	
	public double doubleVal(String input) {
           System.out.println(input);
		try {
			double value = sc.nextDouble();
			sc.nextLine();
			return value;
		} catch(Exception e) {
			System.out.println("Double input only");
		}
		return doubleVal(input);
	}
	
	public long longVal(String input) {
		System.out.println(input);
		try {
			long value = sc.nextLong();
			sc.nextLine();
			return value;
		} catch(Exception e) {
			sc.nextLine();
			System.out.println("Long input only");
		}
		return longVal(input);
	}

}
