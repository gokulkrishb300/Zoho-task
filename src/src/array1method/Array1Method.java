package array1method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Array1Method {

	
	public int findMin(int arr[], int n ) {
	Arrays.sort(arr);
	return arr[0];
	}
	
    static int getKey(Map<Integer,Integer> map,int value){
        for(Integer key : map.keySet()){
            if(value == map.get(key)){
                return key;
            }
        }
        return 0;
    }
        // Complete the function

        public int firstNonRepeating(int arr[], int n) 
        { 
            // Complete the function
            Map<Integer,Integer> map = new HashMap<>();
            int count = 0;
            for(int i = 0 ; i < n ; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i],++count);
                }
                else{
                    count = 0;
                    map.put(arr[i],++count);
                }
            }
            
           
              for(int i=0;i<n;i++){
                  
              if(map.get(arr[i])==1)
              
                return arr[i];
          }
          return 0;
        }
        
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int count = 0;
            int[] output = new int[nums.length];
        
            for(int i = 0 ; i < nums.length ; i ++){
                for(int j = 0 ; j < nums.length ; j++){
                    if(nums[i]>nums[j]){
                        count++;
                    }
                }
                output[i] = count;
                count = 0;
            }
      
            return output;
        }
        
        long maxSubarraySum(int arr[], int n){
            
            // Your code here
        long output = arr[0];
        long max = arr[0];
        for(int i = 1 ; i < n ;i++){
            max = Math.max(max+arr[i],arr[i]);
            output = Math.max(output,max);
        }
        return output;
            }
        
        public static void convertToWave(int arr[], int n){
            
            // Your code here
            
            int temp;
            
            for(int i = 1 ; i < arr.length ; i+=2){           
               temp = arr[i];
               arr[i] = arr[i-1];
               arr[i-1] = temp;
           }
        }
       public static int majorityElement(int a[], int size)
        {
            // your code here
        
            if(size ==1 ){
                return a[0];
            }
            
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0 ; i < size ; i++){
              if(map.containsKey(a[i])){
                  int value = map.get(a[i])+1;
                  map.put(a[i], value);
              
              if(value == size/2){
                  return a[i];
              }
              }
              else{
                  map.put(a[i],0);
              }
        }
        return -1;
    }
        
        long minValueToBalance(long a[] ,int n)
        {

        int sumLeft = 0;
        int sumRight = 0;
        int balance = n/2;
        for(int i = 0 ; i < n ; i++){
            if(i < balance){
            sumLeft += a[i];
            
            } else if(i >= balance){
                sumRight += a[i];
            }
        }
        
        long output = sumLeft - sumRight;
        
        if(output<0){
            return -(output);
        }
        
        return output;
        }
        
        public int[] shuffle(int[] nums, int n) {
        	   
            
            
            int[] output = new int[nums.length];
            
            for(int i = 0 ; i < n ; i++){
                output[i*2] = nums[i];
                output[i*2 +1] = nums[i+n];
            }


           return output;
        }
        
      public  int getPairsCount(int[] arr, int n, int k) {
            // code here
             HashMap <Integer, Integer> nums = new HashMap<>();
            
            int ans = 0;
            
            for (int i = 0; i < n ; i++){
                if (nums.containsKey(k - arr[i])){
                    ans += nums.get(k - arr[i]);
                }
                
                if (nums.containsKey(arr[i]))
                    nums.put(arr[i], nums.get(arr[i]) + 1);
                    
                else
                    nums.put(arr[i], 1);
            }
            
            return ans;
        }
      
      
      public int minimum_difference(int[] nums)
      {
         
      Arrays.sort(nums);
      
      int diff = Integer.MAX_VALUE;
      int length = nums.length;
      for(int i = 0 ; i < length -1 ;i++){
          if(nums[i+1] - nums[i] < diff ){
              diff = nums[i+1] - nums[i];
          }
      }
      return diff;
      }
      
      public ArrayList<Integer> leaders(int arr[], int n){
          // Your code here
          
          ArrayList<Integer> list = new ArrayList<>();
         
         int leader = arr[n-1];
         list.add(leader);
         
         for(int i = n-2 ; i >= 0 ; i--){
             if(arr[i]>=leader){
                 leader = arr[i];
                 list.add(leader);
             }
         }
         Collections.reverse(list);
         return list;
      }
      
      public int minDist(int a[], int n ,int x, int y) {
    	  
    	  int start = -1;
    	  int end = -1;
    	  
    	  int small = Integer.MAX_VALUE;
    	  
    	  for(int i = 0 ; i < n ;i++) {
    		  
    		  if(a[i] == x) {
    			  start = i;
    		  }
    		  else if(a[i] == y) {
    			  end = i;
    		  }
    		  
    		  if(start!=-1 && end!=-1) {
    			  small = Math.min(small, Math.abs(end-start));
    		  }
    	  }
    	
    	  
    	  return small == Integer.MAX_VALUE ? -1 : small;
      }
      
      void rearrange(int a[], int n) {
          // code here
          int[] even = new int[n];
          int[] odd = new int[n];
          int e=0, o=0;
          for(int i=0; i<n; i++){
              if(a[i]>=0)
              even[e++]=a[i];
              else
              odd[o++]=a[i];
          }
          int k=0, l=0;
          for(int i=0; i<n; i++){
              if(k<e)
              a[i]=even[k++];
              else
              i--;
              if(l<o)
              a[i+1]=odd[l++];
              else
              i--;
            i++;  
          }
      }
      
      public boolean findsum(int arr[],int n)
      {
          //Your code here
       Set<Integer> set = new HashSet<>();
       
       int sum = 0 ;
       
       set.add(0);
       
       for(int i = 0 ; i < n ; i++){
           
           sum += arr[i];
           
           if(set.contains(sum)){
               
              return true;
           }
           set.add(sum);
       }
       
       return false;
      }
}
