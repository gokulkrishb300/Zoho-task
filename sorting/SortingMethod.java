package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortingMethod {

	public void mergeSort(int[] arr,int l, int r) {
		if(l < r) {
			int m = l+(r-l)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
	
	private void merge(int[] arr, int l, int m,int r) {
		
		int n1 = m-l+1;
		int n2 = r-m;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i = 0 ; i < n1 ; i++) {
			L[i] = arr[l+i];
		}
		
		for(int j = 0 ; j < n2 ;j++) {
			R[j] = arr[m+1+j];
		}
		
		int i = 0 , j = 0 , k = l;
		
		while(i < n1 && j < n2) {
			if(L[i]<=R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = L[i];
			i++;k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;k++;
		}
	}
	
	 static void swap(int[] arr,int i , int j){
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;

	    }
	    
	    
	    static void quickSort(int[] arr,int low , int high){
	        if(low<high){
	            int pi = partition(arr,low,high);
	            quickSort(arr,low,pi-1);
	            quickSort(arr,pi+1,high);
	        }
	    }
	    
	    static int partition(int[] arr,int low, int high){
	        
	        int pivot = arr[high];
	        
	        int i = (low-1);
	        
	        for(int j = low ; j <= high-1 ; j++){
	            if(arr[j] < pivot){
	                i++;
	                swap(arr,i,j);
	            }
	        }
	        swap(arr,i+1,high);
	        return (i+1);
	    }
	    
	    
	    //Function to find the minimum number of swaps required to sort the array.
	    public int minSwaps(int nums[])
	    {
	        // Code here
	        int length = nums.length;
	        
	     
	        
	        int[] result = new int[length];
	        
	        for(int i = 0 ; i < length ; i++){
	            result[i] = nums[i];
	        }
	        quickSort(result,0,length-1);
	        
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        
	        for(int i = 0 ; i < length ; i++){
	            map.put(result[i],i);
	        }
	        
	        int count = 0 ;
	        
	        for(int i = 0 ; i < length ; i++){
	            while(map.get(nums[i])!=i){
	                count++;
	                swap(nums,map.get(nums[i]),i);
	            }
	        }
	  
	        return count;
	    }
	    
	    public void merge(int arr1[], int arr2[], int n, int m) {
	        // code here
	    
	    int length = arr1.length + arr2.length;
	    
	    int[] output = new int[length];
	    
	    for(int i = 0 ; i < n ; i++){
	        output[i] = arr1[i];
	    }
	    
	    for(int i = n,j = 0 ; i < length ; i++){
	        output[i] = arr2[j++];
	    }
	    
	    mergeSort(output,0,(output.length)-1);
	    
	    for(int i = 0 ; i < n ; i++){
	        arr1[i] = output[i];
	    }
	    
	    for(int i = 0,j=n ; i < m ; i++){
	        arr2[i] = output[j++];
	    }
	    
	    for(int i : arr1) {
	    	System.out.print(i+" ");
	    }
	    for(int i : arr2) {
	    	System.out.print(" "+i);
	    }
	}
	    
	    public boolean isAnagram(String a,String b)
	    {
	        
	        // Your code here
	        
	        if(a.length() != b.length()){
	            return false;
	        }   
	       
	        char[] ch1 = a.toCharArray();
	        Arrays.sort(ch1);

	        char[] ch2 = b.toCharArray();
	        Arrays.sort(ch2);
	    
	        return Arrays.equals(ch1,ch2);
	    }
	    
	    public  boolean check(int A[],int B[],int N)
	    {
	        //Your code here
	        if(A.length!=B.length){
	            return false;
	        }
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        return Arrays.equals(A,B);
	    }
	    
	    static void merge(int[] arr, int l , int m , int r , int k){
	        
	          int n1 = m-l+1;
	          int n2 = r-m;
	          
	          int[] L = new int[n1];
	          int[] R = new int[n2];
	          
	          for(int i = 0 ; i < n1 ; i++){
	              L[i] = arr[l+i];
	          }
	          
	          for(int j = 0 ; j < n2 ; j++){
	              R[j] = arr[j+m+1];
	          }
	          
	          int i = 0 , j = 0 , q = l;
	          while(i < n1 && j < n2){
	              if(Math.abs(L[i]-k)<=Math.abs(R[j]-k)){
	                  arr[q] = L[i];
	                  i++;
	              }else{
	                  arr[q] = R[j];
	                  j++;
	              }
	              q++;
	          }
	          
	          while(i < n1){
	              arr[q] = L[i];
	              i++;q++;
	          }
	          
	          while(j < n2){
	              arr[q] = R[j];
	              j++;q++;
	          }
	    }
	    
	    static void mergeSort(int[] arr,int l,int r,int k){
	       if(l<r){
	           int m = l + (r-l)/2;
	           
	           mergeSort(arr,l,m,k);
	           
	           mergeSort(arr,m+1,r,k);
	           
	           merge(arr,l,m,r,k);
	       }    
	    }
	    
	    public void sortABS(int[] arr, int n , int k){
	        
	        int length = arr.length;
	        
	        mergeSort(arr,0,length-1,k);
	    }
	    
	    
}
