package array1runner;
import java.util.*;
import array1method.Array1Method;
public class Array1Runner {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Array1Method array = new Array1Method();
	int dial = sc.nextInt();
	switch(dial) {
	case 1:
	{
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
	
		System.out.println(array.findMin(arr, n));
	}
		break;
	case 2:
	{
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(array.findMin(arr, n));
	}
		break;
	case 3:
	{
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i = 0 ; i < size ; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(array.majorityElement(arr, size));
	}
	break;
	
	case 4:
	{
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i = 0 ; i < size ; i++) {
			arr[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		System.out.println(array.shuffle(arr, n));
	}
	break;
	default:
		System.out.println("Not available");
		break;
	}
}
}