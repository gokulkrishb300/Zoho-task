package strings2runner;
import strings2method.String2Method;
import java.util.*;

public class String2Runner {
public static void main(String[] args) {
	String2Method method = new String2Method();
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	switch(n) {
	case 7:
	{
		int num = sc.nextInt();
		method.countAndSay(num);
		break;
	}
	case 8:
	{
		String str = sc.next();
		method.modify(str);
		break;
	}
	case 9:
	{
		String str = sc.next();
		System.out.println(method.encryptString(str));
		break;
	}
	case 10:
	{
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(method.areIsomorphic(str1, str2));
		break;
	}
	
}
	sc.close();
}
}