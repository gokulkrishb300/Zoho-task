package strings1runner;

import strings1method.Strings1;
import java.util.*;

public class Strings1runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Strings1 method = new Strings1();

		int target = sc.nextInt();
		switch (target) {

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
		    sc.nextLine();
			String space = sc.nextLine();
			System.out.println(method.reverseWithSpacesIntact(space));
			break;
			
			
		case 5:
			System.out.println(method.crossPattern(sc.next()));
			break;
//		case 6:
//			System.out.println(method.kPangram(sc.next(), sc.nextInt()));
//			break;
		case 7:
			System.out.println(method.maxChars(sc.next()));
			break;
		case 8:
			
			System.out.println(method.find_permutation(sc.next()));
			break;

	    case 9:
		  String s = sc.next();
		  int length = s.length();
		  int indices[] = new int[length];
		  
		  for(int i=0 ; i < length ; i++) {
			  indices[i]=sc.nextInt();
		  } 
		 
		  System.out.println(method.restoreString(s,indices));
		  break;
	case 11:
	    int N = sc.nextInt();
	    String[] string_list = new String[N];
	    for(int i = 0 ; i < N ; i++) {
	    	string_list[i] = sc.next();
	    }
		System.out.print(method.Anagrams(string_list));
		break;
//	case 12:
//		System.out.println(method.wordBreak(sc.next(),sc.next());
//		break;
		case 13:
			System.out.println(method.CountWays(sc.next()));
			break;
		default:
			System.out.println("not available");
			break;
		}

		sc.close();
	}
}