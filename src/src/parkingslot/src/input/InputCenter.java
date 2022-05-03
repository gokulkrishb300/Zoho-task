package input;
import java.util.*;

public class InputCenter{
Scanner sc = new Scanner(System.in);

public int number(String input) {
	System.out.println(input);
	
	try {
	int number = sc.nextInt();
	sc.nextLine();
	return number;
	}
	catch(Exception e) {
		
		sc.nextLine();
		System.out.println("number type only accepted");
	}
	
	return number(input);
}

public long longVal(String input) {
	System.out.println(input);
	
	try {
	long number = sc.nextLong();
	sc.nextLine();
	return number;
	}
	catch(Exception e) {
		sc.nextLine();
		System.out.println("long type only accepted");
	}
	
	return longVal(input);
}

public float floatVal(String input) {
	System.out.println(input);
	
	try {
    float number = sc.nextFloat();
	sc.nextLine();
	return number;
	}
	catch(Exception e) {
		sc.nextLine();
		System.out.println("float type only accepted");
	}
	
	return floatVal(input);
}

public double doubleVal(String input) {
	System.out.println(input);
	
	try {
    double number = sc.nextDouble();
	sc.nextLine();
	return number;
	}
	catch(Exception e) {
		sc.nextLine();
		System.out.println("double type only accepted");
	}
	
	return doubleVal(input);
}

public String stringInput(String input) {
	System.out.println(input);
	
	try {
    String value = sc.nextLine();
	if(!value.isEmpty() || value != null)
	return value;
	}
	catch(Exception e) {
		sc.nextLine();
		System.out.println("String type only accepted");
	}
	
	return stringInput(input);
}

public char charInput(String input) {
	System.out.println(input);
	
	try {
    char value = sc.next().charAt(0);
	return value;
    
	}
	catch(Exception e) {
		sc.nextLine();
		System.out.println("char type only accepted");
	}
	
	return charInput(input);
}
}
