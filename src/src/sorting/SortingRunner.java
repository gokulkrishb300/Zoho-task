package sorting;
import java.util.*;

public class SortingRunner {
public static void main(String[] args) {
	SortingMethod method = new SortingMethod();
	Scanner sc = new Scanner(System.in);
	int dial = sc.nextInt();
	
	switch(dial) {
	case 0 : 
	{
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++) {
			arr[i] = sc.nextInt();
		}
       method.mergeSort(arr, 0, size-1);
       
       for(int i = 0 ; i < size ; i++) {
    	   System.out.print(arr[i]+" ");
       }
	}
	break;
	
	case 1:
	{
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i = 0 ; i < size ; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(method.minSwaps(arr));
	}
	break;
	case 2:
	{
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for(int i = 0 ; i < m ; i++) {
			arr2[i] = sc.nextInt();
		}
      method.merge(arr1, arr2, n, m);
	}
	break;
	case 3:
	{
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(method.isAnagram(a, b));
	}
	break;
	case 4:
	{
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = sc.nextInt();
		}
	
		int[] arr2 = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
    method.check(arr1, arr2, n);
	}
	break;
	case 5:
	{
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = sc.nextInt();
		}
	
	    int k = sc.nextInt();
	    
    method.sortABS(arr1, n, k);
	}
	break;
	case 6:
	{
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = sc.nextInt();
		}
	method.arraySortedOrNot(arr1, n);
	}
	break;
	case 7:
	{
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = sc.nextInt();
		}
	
	    int k = sc.nextInt();
	    
     method.toyCount(n, k, arr1);
	}
	break;
	case 8:
	{
		int n = sc.nextInt();
		long[] arr1 = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = sc.nextLong();
		}
	method.bitonicGenerator(arr1, n);
	}
	break;
	}
	sc.close();
}
}