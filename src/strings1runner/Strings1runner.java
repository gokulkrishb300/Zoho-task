package strings1runner;
import strings1method.Strings1;
import java.util.*;

public class Strings1runner {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Strings1 method = new Strings1();
	
	
	int target = sc.nextInt();
	switch(target) {
	
	case 1:
		method.middlePattern(sc.next());
		break;
	case 2:
		System.out.print(method.remainingString(sc.next(), sc.next().charAt(0), sc.nextInt()));
		break;
	case 3:
		System.out.print(method.reverseWords(sc.next()));
		break;
	case 4:
	    System.out.println(method.reverseWithSpacesIntact(sc.next()));
	    break;
	case 5:
		System.out.println(method.crossPattern(sc.next()));
		break;
	case 6:
		System.out.println(method.kPangram(sc.next(), sc.nextInt()));
		break;
	case 7:
		System.out.println(method.maxChars(sc.next()));
		break;
	case 8:
		System.out.println(method.find_permutation(sc.next()));
		break;
	default:
		System.out.println("not available");
		break;
	}
	
	sc.close();
}
}
