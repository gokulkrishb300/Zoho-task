package array2method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array2Method {
    static int largest(int[] arr , int n) {
    	Arrays.sort(arr);
    	return arr[n-1];
    }
    static int smallest(int[] arr , int n ) {
    	Arrays.sort(arr);
    	return arr[0];
    }
    
   public void closestPair(int[] arr,int N,int X) {
		
		int sum = 0;
	    int count = 0;
	    int[] result = new int[N*(N-1)];
	    int[] antiResult = new int[N*(N-1)];
	    int counter = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(arr[i]==arr[j]){continue;};
				sum = arr[i] + arr[j];
		
				if(sum < X) {
					result[count++] = sum;
				}else {
					antiResult[counter++] = sum;
				}
		}
		
	}
		int length = result.length;
		int antiLength = antiResult.length;
	    int near = largest(result,length);
		int far = smallest(antiResult,antiLength);
	    for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
			if(arr[i]==arr[j]){continue;};
				sum = arr[i] + arr[j];
		
				if(sum == near) {
					System.out.println("pair ( "+ arr[i]+"," + arr[j]+" )");
				}else if(sum == far) {
					System.out.println("pair ( "+arr[i]+","+arr[j]+")");
				}
		}
		
	}
		
}



public void clock(int N , int[] A) {
	
	List<Integer> list = new ArrayList<>();
	
	for(int i = 0 ; i < N ; i++) {
		list.add(A[i]);
	}
	
	for(int i = 0 ; i < N ; i++) {
		if(i == 0) {
			list.add(i,A[N-1]);
			list.remove(N);
		}
	}
	
	
	System.out.println(list);
	
	
	

}

public void mismatch(char[] Arr1 , char[] Arr2) {
	
	if(Arr1.length!= Arr2.length) {
		System.out.println("Invalid Array");
		
	}
	String result = "";
    int i = 0;
    int N = Arr1.length;
    
	while(i<N) {
		if(Arr1[i]==Arr2[i]) {
			i++;
			continue;
		} 
		System.out.print(Arr1[i]+""+Arr2[i]+", ");
		i++;
		
	}
	
}


}

































































