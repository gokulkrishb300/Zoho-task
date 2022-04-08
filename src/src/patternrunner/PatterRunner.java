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
		method.pyramidpattern(n);
	}
	break;
	case 5:
	{
		int n = sc.nextInt();
		method.pyramidpattern(n);
	}
	break;
	}
	sc.close();
	
}
}
