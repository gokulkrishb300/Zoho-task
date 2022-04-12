package patternrunner;
import patternmethod.PatternMethod;
import java.util.*;

public class PatterRunner {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	PatternMethod method = new PatternMethod();
	int dial = sc.nextInt();
	
	switch(dial) {
	case 1:
	{
		int n = sc.nextInt();
		method.pyramidpattern(n);
	}
	break;
	case 2:
	{
		int n = sc.nextInt();
		method.rightTriangle(n);
	}
	break;
	case 3:
	{
		int n = sc.nextInt();
		method.leftTriangle(n);
	}
	break;
	case 4:
	{
		int n = sc.nextInt();
		method.diamond(n);
	}
	break;
	case 5:
	{
		int n = sc.nextInt();
		method.rightPascal(n);
	}
	break;
	case 6:
	{
		int n = sc.nextInt();
		method.sandGlass(n);
	}
	break;
	case 7:
	{
		int n = sc.nextInt();
		method.triangle(n);
	}
	break;
	case 8:
	{
		int n = sc.nextInt();
		method.diamondEmpty(n);
	}
	break;
	case 9:
	{
		int n = sc.nextInt();
		method.numberPattern(n);
	}
	break;
	case 10:
	{
		int n = sc.nextInt();
		method.printPascal(n);
	}
	break;
	case 11:
	{
		int n = sc.nextInt();
		method.diamondNumber(n);
	}
	break;
	case 12:
	{
		int n = sc.nextInt();
		method.zPattern(n);
	}
	break;
	case 13:
	{
		int n = sc.nextInt();
		method.xAndO(n);
	}
	break;
	case 14:
	{
		int n = sc.nextInt();
		method.spiral(n);
	}
	break;
	case 15:
	{
		sc.nextLine();
		String input = sc.nextLine();
		method.oddLength(input);
	}
	break;
	case 16:
	{
		sc.nextLine();
		String input = sc.nextLine();
		method.alpha(input);
	}
	break;
	}
	sc.close();
	
}
}
