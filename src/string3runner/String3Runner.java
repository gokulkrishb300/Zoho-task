package string3runner;
import string3method.String3Method;
import java.util.*;

public class String3Runner {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String3Method method = new String3Method();
	
	int dial = sc.nextInt();
			sc.nextLine();
	switch(dial) {
	case 1:
	{
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(method.rotate(str1, str2));
	}
	break;
	
	
	case 2:
	{
		int n = sc.nextInt();
		String[] input = new String[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = sc.nextLine();
		}
		System.out.println(method.fragment(n, input));
	}
	break;
	
	case 3:
	{
		String str1 = sc.nextLine();
		String str2  = sc.nextLine();
		System.out.println(method.unMatchPair(str1, str2));
	}
	break;
}
	sc.close();
}
}
