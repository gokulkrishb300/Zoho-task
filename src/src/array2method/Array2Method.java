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
	   int max = Integer.MIN_VALUE;

	   String output = "";
	   for(int i = 0 ; i < N ; i++) {
		   for(int j = i+1 ; j < N ; j++) {
			   sum = arr[i] + arr[j];
			   max = Math.max(max, sum);
			   if(X > max) {
				   output = arr[i] +" "+ arr[j];
			   }
			
			   
		   }
	   }
	   System.out.println(output);
		
}



public void clock(int N , int[] A) {

    int temp = A[N-1];
  
	for(int i = N-1 ; i > 0 ; i--) {
		A[i] = A[i-1];
	}
	A[0] = temp;
	
	
	for(int i = 0 ; i < N ; i++) {
		System.out.print(A[i]+" ");
	}

	
	
	
}

public void mismatch(char[] Arr1 , char[] Arr2) {
	

	String output = "";
	String arr2 = "";
    int i = 0;
    int N = Arr1.length;
    
	while(i<N) {
		if(Arr1[i]!=Arr2[i]) {
		output += Arr1[i]+"";
		arr2 += Arr2[i]+"";
		} 
		else if(output.length()>0){
			output +=","+arr2+",";
			arr2 ="";
		} else if(i == N-1) { output += "."; }
		i++;
	}
	int length = output.length();
	String modified = output.substring(0,length-1);
	System.out.println(modified+".");
}

public void rotate(int[] arr,int rotate) {

	int length = arr.length;
	while(rotate>0) {
	int temp = arr[length-1];
	
	for(int i = length-1 ; i > 0 ; i--) {
		arr[i] = arr[i-1];
	}
	arr[0] = temp;
    rotate--;
	}
	
	for(int i = 0 ; i < length ; i ++) {
		System.out.print(arr[i]+" ");
	}
}

public void duplicate(int[] arr) {
	
	for(int i = 0 ; i < arr.length ; i++) {
		for(int j = 0 ; j < arr.length ; j++) {
			if( i == j ) { continue; }
			if(arr[i] < arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
	int count = 1;
		for(int i = 0 ; i < arr.length-1 ; i++) {
			if(arr[i]==arr[i+1]) {
				count++;
			}else {
		    System.out.println(arr[i]+" "+count);
					count = 1;
				}	
		if(i == arr.length -2) {
				System.out.println(arr[i]+" "+count);
			
		}
		}
	
		
}

public void sumPair(int[] arr, int target) {
	
	
	Set<Integer> set = new HashSet<>();
	
for(int i = 0 ; i < arr.length ;i++) {
	set.add(arr[i]);
}

int[] newArr = new int[set.size()];

int iter = 0;
for(int values:set) {
	newArr[iter++] = values;
}

int sum = 0;
for(int i = 0 ; i < set.size() ;i++) {
	for(int j = i+1 ; j < set.size() ; j++) {
		
		sum = newArr[i] + newArr[j];
		if(sum == target) {
			System.out.println("("+newArr[i]+","+newArr[j]+")");
		}
	}
}
}

static int sod(int number) {
	int sum = 0,temp = 0;
	while(number>0) {
		temp = number % 10;
		sum += temp;
		number /= 10;
	}
	return sum;
}


public void sumOfDigits(int arr[],int N) {
	
	for(int i = 0 ; i < arr.length ; i++) {
		arr[sod(arr[i])] = arr[i];
		System.out.print(arr[i]+" ");
	}
	int count = 0;
	for(int i = N ; i < N*N ;i++ ) {
		if(arr[i]!=0) {
			arr[count++] = arr[i];
		}
	}

	for(int i = 0 ; i < count ; i++) {
		System.out.print(arr[i]+" ");
	}
}

public void minDiff(int arr[]) {
int length = arr.length;
int min = Integer.MAX_VALUE;
String output = "";

  for(int i = 0 ; i < length ; i++) {
	  for(int j = i+1 ; j < length ;j++) {
	
  if(arr[i]==0 || arr[j]==0) {continue;}
  int diff = Math.abs(arr[i] - arr[j]);
  if(min > diff) {
  min = Math.min(min, diff);
  output = arr[i]+" "+arr[j];
  }
  }
  }
  
  System.out.println(output);

}

public void leftRotate(int rotate , int arr[]) {
	int length = arr.length;;
	
	
	while(rotate>0) {
	
	for(int i = 0 ; i < length-1 ; i++) {
		int temp = arr[i];
		arr[i] =arr[i+1];
		arr[i+1] = temp;
	}
	
	rotate--;
	}
	
	for(int i = 0 ;i < length ; i++) {
		System.out.print(arr[i]+" ");
	}
}

public void possibleWay(int n , int m , int arr[]) {
	
	Arrays.sort(arr);
	for(int i = 0 ; i < m ; i++) {
		int iter = n , sum = 0 ;
		String output = "";
		while(iter>0) {
			 sum += arr[i];
			  output +=arr[i]+" ";
			if(sum == n) {
				System.out.println(output);
				break;
			}
			iter--;
		}
	}
	
	for(int i = 0 ; i < m ; i++) {
	    int sum = 0;
		for(int j = i+1 ; j < m ; j++) {
			sum += arr[i]+arr[j];
			if(sum == n) {
				System.out.println(arr[i]+" "+arr[j]);
				break;
			}
			sum = 0;
		}
	}
	
	for(int i = 0 ; i < m-1 ; i++) {
		int sum = 0, iter = n;
		while(iter>0) {
			sum += arr[i] + arr[i] + arr[i+1];
			if(sum == n) {
		    System.out.println(arr[i] +" "+ arr[i] +" "+ arr[i+1]);
			break;
			}
			iter--;
		}
	}
}

public void ueiOperation(List<Integer> list1 , List<Integer> list2) {

	List<Integer> union = new ArrayList<>();
	
	for(int i = 0 ; i < list1.size() ; i++) {
		if(!union.contains(list1.get(i))) {
			union.add(list1.get(i));
		}
	}
	for(int i = 0 ; i < list2.size() ; i++) {
		if(!union.contains(list2.get(i))) {
			union.add(list2.get(i));
		}
	}
	System.out.println("Union: "+ union);
	
	List<Integer> except = new ArrayList<>();
	
	for(int i = 0 ; i < list1.size() ; i++) {
		if(list1.get(i)%2==0) {
			except.add(list1.get(i));
		}
	}
	
	for(int i = 0 ; i < list2.size(); i++) {
		if(list2.get(i)%2!=0) {
			except.add(list2.get(i));
		}
	}
	
	System.out.println("Except: "+except);
	
	list1.retainAll(list2);
	
	System.out.println("Intersect: "+list1);	
}

																						
public void increasingSubSequences(int[] arr) {

int length = arr.length;

int[] output = new int[length];
output[0] = 1;
for(int i = 1 ; i < length ; i++) {
	for(int j = i-1 ; j >= 0 ; j--) {
		if(arr[i]>arr[j]) {
			output[i] = Math.max(output[i], output[j]);
		}
	}
	output[i] += 1;
}

int max = Integer.MIN_VALUE;
for(int values : output) {
	max = Math.max(values, max);
}
System.out.println(max);
}

public boolean non_decreasing(int [] arr) {
	int count = 0;
	for(int i = 0 ; i < arr.length ;i++) {
		if(arr[i]>arr[i+1]) {
			count++;
		}
	}
	if(count<=1) {
		return true;
	}
	return false;
}

public void largest(List<Integer> list) {
	
	Collections.sort(list);
	//System.out.println(list);
	int length = list.size();
    long max = (long)list.get(length-1) * list.get(length-2) * list.get(length-3);
   // System.out.println(max);
    long min = (long)list.get(0) * list.get(1) * list.get(length-1);
   // System.out.println(min);
	System.out.println(Math.max(max, min));
}

public int perfectDigits(int n) {
	int count = 0;
    for(int num = 19 ;; num +=9) {
    	int sum = 0;
    	for(int x = num ; x > 0 ; x/=10) {
    		sum += x % 10;
    	}
    	
    	if(sum == 10) {
    		count++;
    	}
    	if(count == n) {
    		return num;
    	}
    }
}

public void triangleNum(int N, int arr[]) {

	/*
	 * int i = 0;
	 * 
	 * System.out.println(arr[i]); System.out.println(arr[i+1]+" "+arr[i+5]);
	 * System.out.println(arr[i+2]+" "+arr[i+6]+" "+arr[i+9]);
	 * System.out.println(arr[i+3]+" "+arr[i+7]+" "+arr[i+10]+" "+arr[i+12]);
	 * System.out.println(arr[i+4]+" "+arr[i+8]+" "+arr[i+11]+" "+arr[i+13]+" "+arr[
	 * i+14]);
	 */
	int rows=5;
	int k=1;
	for (int i = 1; i <= rows; i++)
    {
        k=i;
        for (int j = 1; j <= i; j++)
        {
            System.out.print(arr[k-1] + " ");
            k = k + rows - j; 
        }
        System.out.println();
    }
}

}



















































