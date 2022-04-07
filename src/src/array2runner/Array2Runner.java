package array2runner;
import array2method.Array2Method;
import java.util.*;

public class Array2Runner {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Array2Method method = new Array2Method();
	
	int key = sc.nextInt();
	
	switch(key) {
	case 1 :
	{
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0 ; i < N ;i++) {
			arr[i] = sc.nextInt();
		}
	   method.closestPair(arr, N, X);
	}
	break;
	
	case 2 :
	{
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		
		method.clock(N, A);
	}
	break;
	
	case 3:
	{
		int N = sc.nextInt();
	    char[] Arr1 = new char[N];
	    for(int i = 0 ; i < N ; i++) {
			Arr1[i] = sc.next().charAt(0);
		}
	   
	    int M = sc.nextInt();
		char[] Arr2 = new char[M];
		for(int i = 0 ; i < M ; i++) {
			Arr2[i] = sc.next().charAt(0);
		}
		
		method.mismatch(Arr1, Arr2);
	}
	break;
}
}
}
