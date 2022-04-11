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
		char[] Arr2 = new char[N];
		for(int i = 0 ; i < N ; i++) {
			Arr2[i] = sc.next().charAt(0);
		}
		
		method.mismatch(Arr1, Arr2);
	}
	break;
	case 4:
	{
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		int rotate = N;
		method.rotate(arr,rotate);
	}
	break;
	case 5:
	{
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		method.duplicate(arr);
	}
	break;
	case 6:
	{
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		method.sumPair(arr, target);
	}
	break;
	case 7:
	{
		int N = sc.nextInt();
		int[] arr = new int[N*N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		method.sumOfDigits(arr,N);
	}
	break;
	case 8:
	{
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		method.minDiff(arr);
	}
	break;
	case 9 :
	{
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		
		method.triangleNum(N, A);
	}
	break;
	case 10 :
	{
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		int rotate = sc.nextInt();
		method.leftRotate(rotate, A);
	}
	break;
	case 11 :
	{
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] A = new int[m];
		for(int i = 0 ; i < m ; i++) {
			A[i] = sc.nextInt();
		}
		method.possibleWay(n, m, A);
	}
	break;
	case 12 :
	{
		List<Integer> list1 = new ArrayList<>();
		int n = sc.nextInt();
		for(int i = 0 ; i < n ; i++) {
			list1.add(sc.nextInt());
		}
		List<Integer> list2 = new ArrayList<>();
		int m = sc.nextInt();
		for(int i = 0 ; i < m ; i++) {
			list2.add(sc.nextInt());
		}
		method.ueiOperation(list1, list2);
	}
	break;
	case 13 :
	{
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
	
		method.increasingSubSequences(A);
	}
	break;
	case 14 :
	{
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
	
		method.non_decreasing(A);
	}
	break;
	case 15:
	{
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < N ;i++) {
			list.add(sc.nextInt());
		}
		method.largest(list);
	}
	break;
	case 16:
	{
		int n = sc.nextInt();
		System.out.println(method.perfectDigits(n));
	}
	break;

}
	sc.close();
} 
}


